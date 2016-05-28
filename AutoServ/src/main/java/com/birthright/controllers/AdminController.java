package com.birthright.controllers;

import com.birthright.aspects.annotation.AdminControl;
import com.birthright.aspects.annotation.Logging;
import com.birthright.entity.Claim;
import com.birthright.entity.Orders;
import com.birthright.helpers.Constants;
import com.birthright.service.ClaimService;
import com.birthright.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Birthright on 02.05.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    EntityManagerFactory s;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private OrdersService ordersService;

    @Logging
    @AdminControl
    @RequestMapping(value = "/claims", method = RequestMethod.GET)
    public String getClaims(ModelMap modelMap) {
        modelMap.put("claims", claimService.findAll());
        return "admin/claims";
    }
    @Logging
    @AdminControl
    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin(ModelMap modelMap) {
        return "admin";
    }
    @Logging
    @AdminControl
    @RequestMapping(value = "/claims", method = RequestMethod.POST)
    public String setClaim(@RequestParam Long id, @RequestParam Integer sum, @RequestParam String comment, @RequestParam String status) {
       Claim claim = claimService.findById(id);
        claim.setSum(sum);
        claim.setResponse(comment);
        claim.setStatus(status);
        claimService.saveClaim(claim);
        return "redirect:/admin";
    }

    @Logging
    @AdminControl
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(ModelMap modelMap) {
        List<Orders> ordersList = ordersService.findAll();
        modelMap.put("orders", ordersList);
        return "admin/orders";
    }

    @Logging
    @AdminControl
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String acceptOrders(@RequestParam Long id) {
       Orders orders = ordersService.findOne(id);
        orders.setStatus(Constants.YES_CLAIM);
        ordersService.save(orders);
        return "redirect:/admin/orders";
    }
    @Logging
    @AdminControl
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable Long id, ModelMap modelMap){
        Orders orders = ordersService.findOne(id);
        modelMap.put("order", orders);
        return "admin/order";
    }
}
