package com.birthright.repository;

import com.birthright.entity.OrdersProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface OrdersProductsRepository extends CrudRepository<OrdersProducts, Long> {

}
