package com.birthright.service;

import com.birthright.entity.AutoBrand;
import com.birthright.repository.AutoBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Component
@Service
public class AutoBrandService {
    @Autowired
    private AutoBrandRepository autoBrandRepository;
    public AutoBrand findByName(String name){
         return autoBrandRepository.findByName(name);
    }
    public void saveBrand(AutoBrand name){
        autoBrandRepository.save(name);
    }
    public List<AutoBrand> findAllBrands(){
        Iterable<AutoBrand> autoBrands = autoBrandRepository.findAll();
        List<AutoBrand> brands = new ArrayList<>();
        autoBrands.forEach(brands::add);
        return brands;
    }
    public AutoBrand findOne(Long id){
        return autoBrandRepository.findOne(id);
    }
}
