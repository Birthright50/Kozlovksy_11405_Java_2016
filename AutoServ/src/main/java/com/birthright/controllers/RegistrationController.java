package com.birthright.controllers;


import com.birthright.aspects.annotation.Logging;
import com.birthright.entity.Users;
import com.birthright.helpers.Response;
import com.birthright.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Birthright on 30.04.2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserDetailsService customUserDetailsService;
    @Autowired
    private UserService userService;

    @Logging
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return "registration";
        }
        return "redirect:/home";
    }
    @Logging
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String newUserRegistration(@RequestParam String email, @RequestParam String password,
                                      @RequestParam String name, @RequestParam String lastname) {

        Users user = new Users(password, email, true, name, lastname, "ROLE_USER");
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/check_email", method = RequestMethod.GET)
    public
    @ResponseBody
    Response check(@RequestParam String email) {

        com.birthright.helpers.Response response = new Response();
        if (customUserDetailsService.loadUserByUsername(email) == null) {
            response.setText("ok");
        }
        return response;
    }

}
