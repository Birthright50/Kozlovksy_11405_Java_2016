package com.birthright.service;

import com.birthright.entity.OrdersProducts;
import com.birthright.repository.OrdersProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by birthright on 07.05.16.
 */
@Component
@Service
public class OrdersProductsService {
    @Autowired
    private OrdersProductsRepository productsRepository;

    public void save(OrdersProducts ordersProducts){
        productsRepository.save(ordersProducts);
    }
}
