package com.birthright.service;


import com.birthright.entity.Orders;
import com.birthright.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Component
@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;


    public Orders save(Orders orders){
        return ordersRepository.save(orders);
    }
    public List<Orders> findAllById(Long id){
        return ordersRepository.findByUsersId(id, new Sort(Sort.Direction.DESC, "fDate"));
    }

    public Orders findOne(Long id){
        return ordersRepository.findOne(id);
    }
    public List<Orders> findAll(){
        return ordersRepository.findAll(new Sort(Sort.Direction.ASC, "status"));
    }
}
