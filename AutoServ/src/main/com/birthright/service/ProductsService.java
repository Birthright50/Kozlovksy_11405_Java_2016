package com.birthright.service;

import com.birthright.entity.Products;
import com.birthright.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by birthright on 07.05.16.
 */
@Service
@Component
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public void save(Products products){
        productsRepository.save(products);
    }
    public Products getOne(Long id){
        return productsRepository.findOne(id);
    }
}
