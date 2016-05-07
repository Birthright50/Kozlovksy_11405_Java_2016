package com.birthright.controllers;

import com.birthright.entity.AutoModel;
import com.birthright.entity.OrdersProducts;
import com.birthright.service.AutoBrandService;
import com.birthright.service.AutoModelService;
import com.birthright.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by birthright on 07.05.16.
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {
    @Autowired
    private AutoBrandService autoBrandService;
    @Autowired
    private AutoModelService autoModelService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET)
    public String shop(ModelMap modelMap) {
        modelMap.put("brands", autoBrandService.findAllBrands());
        return "shop";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{brand}/{model}")
    public String showItems(ModelMap modelMap, @PathVariable Long model) {
        AutoModel autoModel = autoModelService.find(model);
        modelMap.put("brands", autoBrandService.findAllBrands());
        modelMap.put("model", autoModel);
        return "/shop/items";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addItem(@RequestParam String url, @RequestParam Long id, HttpSession session) {
        ArrayList list = (ArrayList) session.getAttribute("order");
        if (list == null) {
            list = new ArrayList();
            session.setAttribute("order", list);
        }
        boolean yes = false;
        for (Object aList : list) {
            OrdersProducts order = (OrdersProducts) aList;
            if (Objects.equals(order.getProducts().getId(), id)) {
                yes = true;
                break;
            }
        }
        if (!yes) {
            OrdersProducts ordersProducts = new OrdersProducts();
            ordersProducts.setCount(1);
            ordersProducts.setProducts(productsService.getOne(id));
            list.add(ordersProducts);
        }
        return "redirect:" + url;
    }


}
