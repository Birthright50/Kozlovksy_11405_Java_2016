package com.birthright.controllers;


import com.birthright.aspects.annotation.Logging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public
    @ResponseBody
    String get() {

        return "299002, Sevastopol , Str . picturesque 17\n" +
                "sevastopol@autoservice.ru\n" +
                "+7 (978) 000-00-00 \n" +
                "125047, Moscow, Pushkin street, 21 \n" +
                "moscow@autoservice.ru\n" +
                "8(800)555-35-35\n";
    }

}
