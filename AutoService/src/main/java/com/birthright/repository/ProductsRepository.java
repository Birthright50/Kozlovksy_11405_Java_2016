package com.birthright.repository;

import com.birthright.entity.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
    List<Products> findAllByAutoModelId(Long id, Sort sort);

}
