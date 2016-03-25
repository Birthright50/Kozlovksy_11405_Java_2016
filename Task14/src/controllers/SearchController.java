package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Birthright on 17.03.2016.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    private static final String SEARCH = "search";
    private void putVar(ModelMap model, String type, String placeholder, String parameter) {
        model.put("type", type);
        model.put("placeholder", placeholder);
        model.put("parameter", parameter);
    }

    @RequestMapping(value = "/yahoo", method = RequestMethod.GET)
    public String getYahoo(ModelMap model) {
        putVar(model, "https://search.yahoo.com/search", "yahoo.com", "p");
        return SEARCH;
    }
    @RequestMapping(value = "/baidu", method = RequestMethod.GET)
    public String getBaidu(ModelMap model){
        putVar(model, "http://www.baidu.com/s", "baidu.com", "wd");
        return SEARCH;
    }
    @RequestMapping(value = "/bing", method = RequestMethod.GET)
    public String getBing(ModelMap model){
        putVar(model, "http://www.bing.com/search", "bing.com", "q");
        return SEARCH;
    }
    @RequestMapping(value = "/aol", method = RequestMethod.GET)
    public String getAol(ModelMap model){
        putVar(model, "http://search.aol.com/aol/search?", "aol.com", "q");
        return SEARCH;
    }
}
