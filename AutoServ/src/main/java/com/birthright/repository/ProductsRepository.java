package com.birthright.repository;

import com.birthright.entity.Products;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
}
