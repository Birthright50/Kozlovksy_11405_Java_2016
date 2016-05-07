package com.birthright.repository;

import com.birthright.entity.ToPrice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface ToPriceRepository extends PagingAndSortingRepository<ToPrice, Long> {
       ToPrice findByAutoModel_Id(Long id);

}
