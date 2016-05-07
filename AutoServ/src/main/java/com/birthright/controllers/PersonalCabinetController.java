package com.birthright.controllers;

import com.birthright.entity.Claim;
import com.birthright.entity.Orders;
import com.birthright.entity.OrdersProducts;
import com.birthright.entity.Users;
import com.birthright.helpers.Constants;
import com.birthright.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Birthright on 02.05.2016.
 */
@Controller
@RequestMapping("/personal_cabinet")
public class PersonalCabinetController {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private OrdersProductsService ordprService;
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/claim", method = RequestMethod.POST)
    public String createClaim(@RequestParam String DESIRE_DATE,
                              @RequestParam String REASON) {
        DESIRE_DATE = DESIRE_DATE.replace("T", " ");
        try {
            Timestamp fDate = new Timestamp(SIMPLE_DATE_FORMAT.parse(DESIRE_DATE).getTime());
            Users user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
            Claim claim = new Claim(fDate, REASON, Constants.WAITING_CLAIM, user);
            claimService.saveClaim(claim);
            return "redirect:/personal_cabinet/my-auto";
        } catch (ParseException e) {
            return "redirect:/";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/my-auto")
    public String getClaims(ModelMap modelMap) {
        modelMap.put("claims", claimService.findByUserId(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo().getId()));
        return "personal_cabinet/my-auto";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCabinet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/login";
        }
        return "personal_cabinet";
    }

    @RequestMapping(value = "toDelete", method = POST)
    public String toDelete(@RequestParam Long id, HttpSession session) {
        ArrayList list = (ArrayList) session.getAttribute("order");
        for (int i = 0; i < list.size(); i++) {
            OrdersProducts s = (OrdersProducts) list.get(i);
            if (s.getProducts().getId().equals(id)) {
                list.remove(i);
                break;
            }

        }
        return "redirect:/personal_cabinet/basket";
    }

    @RequestMapping(value = "/delete", method = POST)
    public String delete(@RequestParam Long id) {
        claimService.deleteClaimById(id);
        return "redirect:/personal_cabinet/my-auto";
    }

    @RequestMapping(value = "/configuration", method = RequestMethod.GET)
    public String showConfig() {
        return "personal_cabinet/configuration";
    }

    @RequestMapping(value = "/configuration", method = POST)
    public String setConfig(@RequestParam String LAST_NAME, @RequestParam String NAME, @RequestParam String SECOND_NAME,
                            @RequestParam String PERSONAL_PHONE, @RequestParam String OLD_PASSWORD, @RequestParam String NEW_PASSWORD, @RequestParam String AUTO) {
        Users user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (OLD_PASSWORD.length() != 0) {
            if (!encoder.matches(OLD_PASSWORD, user.getPassword())) {
                return "redirect:/personal_cabinet/configuration?error";
            }
            user.setPassword(encoder.encode(NEW_PASSWORD));
        }
        user.setName(NAME);
        user.setLastname(LAST_NAME);
        user.setSecondName(SECOND_NAME);
        user.setTelephone(PERSONAL_PHONE);
        user.setAutomobile(AUTO);
        userService.saveUser(user);
        return "redirect:/personal_cabinet/configuration?success";
    }

    @RequestMapping(value = "/orders", method = GET)
    public String getOrders(ModelMap modelMap) {
        List<Orders> ordersList = ordersService.findAllById(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo().getId());
        modelMap.put("orders", ordersList);
        return "/personal_cabinet/orders";
    }

    @RequestMapping(method = GET, value = "/orders/{id}")
    public String getOneOrder(ModelMap modelMap, @PathVariable Long id) {
        Orders orders = ordersService.findOne(id);
        if (orders.getUsers().getId().equals(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo().getId())) {
         modelMap.put("order", orders);
            return "personal_cabinet/showOrder";
        }
        return "redirect:/personal_cabinet/orders";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/basket")
    public String showBasket(HttpSession session, ModelMap modelMap) {
        ArrayList list = (ArrayList) session.getAttribute("order");
        modelMap.put("products", list);
        int sum = 0;
        if (list != null) {
            for (Object aList : list) {
                OrdersProducts order = (OrdersProducts) aList;
                sum += order.getCount() * order.getProducts().getPrice();
            }
        }
        modelMap.put("sum", sum);
        session.setAttribute("sum", sum);
        return "/personal_cabinet/basket";
    }

    @RequestMapping(method = POST, value = "/checkout")
    public String makeOrder(HttpSession session, @RequestParam String address, @RequestParam String index, @RequestParam String country, @RequestParam String city) {
        Orders orders = new Orders();
        orders.setUsers(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo());
        orders.setfDate(new Timestamp(new Date().getTime()));
        orders.setAddress(country + "\n" + city + "\n" + index + "\n" + address);
        orders.setSum((Integer) session.getAttribute("sum"));
        orders.setStatus(Constants.WAITING_CLAIM);
        orders = ordersService.save(orders);
        System.out.println(orders.getId());
        ArrayList list = (ArrayList) session.getAttribute("order");
        for (Object aList : list) {
            OrdersProducts order = (OrdersProducts) aList;
            order.setOrdersId(orders.getId());
            order.setProductsId(order.getProducts().getId());
            order.setOrders(null);
            order.setProducts(null);
            ordprService.save(order);
        }
        return "redirect:/personal_cabinet/orders";

    }

    @RequestMapping(method = GET, value = "/checkout")
    public String checkout(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("sum") != null) {
            modelMap.put("sum", session.getAttribute("sum"));
            return "personal_cabinet/checkout";
        }
        return "redirect:/personal_cabinet/basket";
    }

    @RequestMapping(method = POST, value = "/edit")
    public String editBasket(HttpSession session, @RequestParam Long id, @RequestParam Integer count) {
        ArrayList list = (ArrayList) session.getAttribute("order");
        if (count > 0) {
            for (Object aList : list) {
                OrdersProducts order = (OrdersProducts) aList;
                if (order.getProducts().getId().equals(id)) {
                    order.setCount(count);
                    break;
                }

            }
        }

        return "redirect:/personal_cabinet/basket";

    }


}
