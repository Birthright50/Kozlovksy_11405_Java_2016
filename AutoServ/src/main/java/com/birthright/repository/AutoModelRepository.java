package com.birthright.repository;

import com.birthright.entity.AutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Birthright on 06.05.2016.
 */
@Repository
public interface AutoModelRepository extends CrudRepository<AutoModel, Long> {
    AutoModel findByBrand_IdAndName(Long id, String name);
    List<AutoModel> findByBrand_Id(Long id);
}
