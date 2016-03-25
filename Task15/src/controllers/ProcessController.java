package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 18.03.2016.
 */
@Controller
public class ProcessController {
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processPost(@RequestParam String textarea, @RequestParam int select, WebRequest request) {
        String result = null;
        switch (select) {
            case 1:
                result = "Characters : " + textarea.length();
                break;
            case 2:
                result = "Words : " + new StringTokenizer(textarea, " \t\n\r,.").countTokens();
                break;
            case 3:
                result = "Sentences : " + (Pattern.compile("[A-Z]+[^!?.]*").split(textarea).length - 1);
                break;
            case 4:
                result = "Paragraphs : " + textarea.split("\n").length;
        }
        request.setAttribute("result", result, 1);
        return "redirect:/result";
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String processGet() {

        return "process";
    }
}
