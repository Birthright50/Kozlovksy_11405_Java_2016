package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Birthright on 17.03.2016.
 */
@Controller
@RequestMapping("/getdate")
public class GetDateController {
    @RequestMapping(method = RequestMethod.GET)
    public String getDate(ModelMap model){
        model.put("date", new Date());
        return "getdate";
    }
}
