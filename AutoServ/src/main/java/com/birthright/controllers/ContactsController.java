package com.birthright.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by birthright on 06.05.16.
 */
@Controller
public class ContactsController {
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String get() {
        return "contacts";
    }
}
