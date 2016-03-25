package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Birthright on 18.03.2016.
 */
@Controller
public class MathController {
    private static final String MATH = "math";
    @RequestMapping(value = "/add/{first_number}/{second_number}")
    public String mathAdd(ModelMap model, @PathVariable int first_number, @PathVariable int second_number) {
        model.put("result", first_number + " + " + second_number + " = " + (first_number + second_number));
        return MATH;
    }
    @RequestMapping(value = "/mult/{first_number}/{second_number}")
    public String mathMult(ModelMap model, @PathVariable int first_number, @PathVariable int second_number) {
        model.put("result", first_number + " * " + second_number + " = " + (first_number * second_number));
        return MATH;
    }
}
