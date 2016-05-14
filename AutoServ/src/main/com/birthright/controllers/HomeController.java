package com.birthright.controllers;

import com.birthright.aspects.annotation.Logging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Birthright on 27.04.2016.
 */
@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @Logging
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "home";
    }

}
