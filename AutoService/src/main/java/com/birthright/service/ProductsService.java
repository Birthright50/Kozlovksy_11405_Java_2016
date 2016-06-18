package com.birthright.service;

import com.birthright.entity.Products;
import com.birthright.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Service
@Component
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public void save(Products products) {
        productsRepository.save(products);
    }

    public Products getOne(Long id) {
        return productsRepository.findOne(id);
    }

    public List<Products> findAllByIdAndSort(Long id, int type) {
        switch (type) {
            case 1:
                return productsRepository.findAllByAutoModelId(id, new Sort(Sort.Direction.ASC, "price"));

            case 2:
                return productsRepository.findAllByAutoModelId(id, new Sort(Sort.Direction.DESC, "price"));

            case 3:
                return productsRepository.findAllByAutoModelId(id, null);
            default:
                return null;
        }
    }
}
