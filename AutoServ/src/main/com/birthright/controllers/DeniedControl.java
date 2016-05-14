package com.birthright.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by birthright on 07.05.16.
 */
@Controller
@RequestMapping(value = "/403")
public class DeniedControl {
    @RequestMapping(method = RequestMethod.GET)
    public String denied(){
        return "redirect:/";
    }
}
