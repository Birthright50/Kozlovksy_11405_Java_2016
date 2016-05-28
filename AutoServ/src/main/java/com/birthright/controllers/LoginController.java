package com.birthright.controllers;


import com.birthright.aspects.annotation.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Birthright on 01.05.2016.
 */
//  CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
@Controller
public class LoginController {
    @Autowired
    EntityManagerFactory s;
    @RequestMapping(value = "/success_log", method = RequestMethod.GET)
    public String success() {
        return "redirect:/";
    }
    @Logging
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return "login";
        }
        return "redirect:/";
    }

}
