package com.birthright.repository;


import com.birthright.entity.AutoBrand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Birthright on 06.05.2016.
 */
@Repository
public interface AutoBrandRepository extends CrudRepository<AutoBrand, Long> {
    AutoBrand findByName(String name);
}
