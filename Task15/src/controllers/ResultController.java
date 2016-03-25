package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Birthright on 18.03.2016.
 */
@Controller
public class ResultController {
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result (ModelMap map, WebRequest request){
        map.put("result", request.getAttribute("result", 1));
        return "result";
    }
}
