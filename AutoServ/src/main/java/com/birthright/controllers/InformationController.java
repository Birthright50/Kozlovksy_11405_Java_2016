package com.birthright.controllers;

import com.birthright.entity.Information;
import com.birthright.helpers.Constants;
import com.birthright.service.InformationService;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Birthright on 02.05.2016.
 */
@Controller
@RequestMapping(value = "/information")
public class InformationController {

    @Autowired
    private InformationService informationService;
    @Autowired
    ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public String getInformation(ModelMap model) {
        model.put("news", informationService.getTop3InformationByTypeOrderByDate(Constants.NEWS_TYPE));
        model.put("articles", informationService.getTop3InformationByTypeOrderByDate(Constants.ARTICLE_TYPE));
        model.put("spec", informationService.getTop3InformationByTypeOrderByDate(Constants.SPEC_TYPE));
        return "information";
    }

    @RequestMapping(value = "/spec", method = RequestMethod.GET)
    public String getSpecInfo(ModelMap modelMap) {
        modelMap.put("spec", informationService.getInformationByTypeOrderByDate(Constants.SPEC_TYPE));
        return "spec";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showToAdd() {

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam MultipartFile foto, @RequestParam String preview,
                      @RequestParam String text, @RequestParam Integer radio, @RequestParam String name) {
        try {
            Files.write(foto.getBytes(), new File(servletContext.getRealPath("/") + "/resources/images/" + foto.getOriginalFilename()));
            informationService.saveInformation(new Information(radio, name, text, "/resources/images/" + foto.getOriginalFilename(), new Date(Calendar.getInstance().getTimeInMillis()), preview));
            return "redirect:/information";
        } catch (IOException e) {
            return "redirect:/add?error";
        }
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id){
        informationService.deleteInformation(id);
        return "redirect:/information";
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public String getAllInfo(ModelMap modelMap, @PathVariable String type) {
        switch (type) {
            case "news":
                modelMap.put("title", "Новости");
                modelMap.put("url", "news");
                modelMap.put("type", informationService.getInformationByTypeOrderByDate(Constants.NEWS_TYPE));
                break;
            case "articles":
                modelMap.put("url", "articles");
                modelMap.put("title", "Статьи");
                modelMap.put("type", informationService.getInformationByTypeOrderByDate(Constants.ARTICLE_TYPE));
                break;
        }
        return "type";
    }

    @RequestMapping(value = "/{type}/{id}", method = RequestMethod.GET)
    public String getOneInfo(ModelMap modelMap, @PathVariable String type, @PathVariable Long id) {
        switch (type) {
            case "news":
                modelMap.put("title", "Новости");
                break;
            case "articles":
                modelMap.put("title", "Статьи");
                break;
            case "spec":
                modelMap.put("title", "Спецпредложения");
                break;
        }
        modelMap.put("template", informationService.getInformation(id));
        return "one";
    }
}
