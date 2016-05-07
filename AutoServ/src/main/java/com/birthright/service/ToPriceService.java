package com.birthright.service;

import com.birthright.entity.ToPrice;
import com.birthright.repository.ToPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by birthright on 07.05.16.
 */
@Component
@Service
public class ToPriceService {
    @Autowired
    private ToPriceRepository toPriceRepository;

    public ToPrice find(Long id){
        return toPriceRepository.findByAutoModel_Id(id);
    }
    public void save(ToPrice toPrice){
        toPriceRepository.save(toPrice);
    }

    public ToPrice findOne(Long id){
        return toPriceRepository.findOne(id);
    }
}
