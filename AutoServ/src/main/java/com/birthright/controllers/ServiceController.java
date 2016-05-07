package com.birthright.controllers;

import com.birthright.entity.AutoBrand;
import com.birthright.entity.AutoModel;
import com.birthright.entity.Products;
import com.birthright.entity.ToPrice;
import com.birthright.service.AutoBrandService;
import com.birthright.service.AutoModelService;
import com.birthright.service.ProductsService;
import com.birthright.service.ToPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by birthright on 07.05.16.
 */
@Controller
@RequestMapping(value = "/services")
public class ServiceController {
    @Autowired
    private AutoBrandService autoBrandService;
    @Autowired
    private AutoModelService autoModelService;
    @Autowired
    private ToPriceService toPriceService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(ModelMap modelMap) {
        modelMap.put("brands", autoBrandService.findAllBrands());
        return "service/addProduct";
    }

    @RequestMapping(value = "/to", method = RequestMethod.GET)
    public String getToList(ModelMap modelMap) {
        modelMap.put("brands", autoBrandService.findAllBrands());
        return "service/to";
    }

    @RequestMapping(value = "/to/{brand}", method = RequestMethod.GET)
    public String getBrandPrice(@PathVariable Long brand, ModelMap modelMap) {
        modelMap.put("brand", autoBrandService.findOne(brand));
        modelMap.put("models", autoModelService.findAllModelById(brand));
        return "/service/to/car";
    }

    @RequestMapping(value = "/to", method = RequestMethod.POST)
    public String editPrice(@RequestParam Long id, @RequestParam Integer price) {
        ToPrice toPrice = toPriceService.findOne(id);
        toPrice.setPrice(price);
        toPriceService.save(toPrice);
        return "redirect:/services/to";

    }


    @RequestMapping(method = RequestMethod.GET)
    public String service() {
        return "service";
    }

    @RequestMapping(value = "/repair", method = RequestMethod.GET)
    public String getRepair() {
        return "service/repair";
    }

    @RequestMapping(value = "/addBrand", method = RequestMethod.GET)
    public String addBrand() {
        return "service/addBrand";
    }

    @RequestMapping(value = "/addModel", method = RequestMethod.GET)
    public String addModel(ModelMap modelMap) {
        modelMap.put("brands", autoBrandService.findAllBrands());
        return "service/addModel";
    }

    @RequestMapping(value = "/addTo", method = RequestMethod.GET)
    public String addTo(ModelMap modelMap) {
        modelMap.put("brands", autoBrandService.findAllBrands());
        return "service/addTo";
    }

    @RequestMapping(value = "/addBrand", method = RequestMethod.POST)
    public String postBrand(@RequestParam String brand) {
        AutoBrand autoBrand = autoBrandService.findByName(brand);
        if (autoBrand == null) {
            autoBrand = new AutoBrand(brand);
            autoBrandService.saveBrand(autoBrand);
            return "redirect:/services/addBrand?success";
        } else {
            return "redirect:/services/addBrand?error";
        }
    }

    @RequestMapping(value = "/addModel", method = RequestMethod.POST)
    public String postModel(@RequestParam Long brand, @RequestParam String model) {
        AutoModel autoModel = autoModelService.findModel(brand, model);
        if (autoModel == null) {
            autoModel = new AutoModel(model, autoBrandService.findOne(brand));
            autoModelService.saveModel(autoModel);
            return "redirect:/services/addModel?success";
        } else {
            return "redirect:/services/addModel?error";
        }
    }

    @RequestMapping(value = "/addTo", method = RequestMethod.POST)
    public String postTo(@RequestParam Long model, @RequestParam Integer price) {
        ToPrice toPrice = toPriceService.find(model);
        if (toPrice == null) {
            toPrice = new ToPrice(price, autoModelService.find(model));
            toPriceService.save(toPrice);
            return "redirect:/services/addTo?success";
        } else {
            return "redirect:/services/addTo?error";
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String postTo(@RequestParam Long model, @RequestParam Integer price, @RequestParam String description, @RequestParam String name) {
        Products products = new Products(name, description, price, autoModelService.find(model));
        productsService.save(products);
        return "redirect:/services/addProduct?success";
    }
}
