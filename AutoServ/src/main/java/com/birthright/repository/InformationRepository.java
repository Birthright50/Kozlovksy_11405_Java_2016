package com.birthright.repository;


import com.birthright.entity.Information;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Birthright on 03.05.2016.
 */
@Repository
public interface InformationRepository extends PagingAndSortingRepository<Information, Long> {
    List<Information> findByType(Integer type, Sort sort);

    List<Information> findTop3ByType(Integer Type, Sort sort);
}
