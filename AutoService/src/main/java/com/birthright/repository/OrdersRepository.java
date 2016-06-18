package com.birthright.repository;


import com.birthright.entity.Orders;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Long> {
    List<Orders> findByUsersId(Long id, Sort sort);
    List<Orders> findAll(Sort sort);
}
