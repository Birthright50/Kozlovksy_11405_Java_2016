package com.birthright.service;

import com.birthright.entity.Information;
import com.birthright.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Birthright on 03.05.2016.
 */
@Component
@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public List<Information> getTop3InformationByTypeOrderByDate(Integer type) {
        return informationRepository.findTop3ByType(type, new Sort(Sort.Direction.DESC, "fDate"));
    }

    public List<Information> getInformationByTypeOrderByDate(Integer type) {
        return informationRepository.findByType(type, new Sort(Sort.Direction.DESC, "fDate"));
    }

    public Information getInformation(Long id) {
        return informationRepository.findOne(id);
    }

    public void saveInformation(Information information) {
        informationRepository.save(information);
    }

    public void deleteInformation(Long id) {
        informationRepository.delete(id);
    }
}
