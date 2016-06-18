package com.birthright.service;


import com.birthright.entity.AutoModel;
import com.birthright.repository.AutoModelRepository;
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
public class AutoModelService {
    @Autowired
    private AutoModelRepository autoModelRepository;

    public AutoModel findModel(Long id, String name) {
        return autoModelRepository.findByBrand_IdAndName(id, name);
    }

    public void saveModel(AutoModel autoModel) {
        autoModelRepository.save(autoModel);
    }

    public List<AutoModel> findAllModels() {
        Iterable<AutoModel> autoModels = autoModelRepository.findAll();
        System.out.println(autoModels);
        List<AutoModel> autoModels1 = new ArrayList<>();
        autoModels.forEach(autoModels1::add);
        return autoModels1;
    }

    public List<AutoModel> findAllModelById(Long id) {
          return autoModelRepository.findByBrand_Id(id);
    }

    public AutoModel find(Long id) {
        return autoModelRepository.findOne(id);
    }
}
