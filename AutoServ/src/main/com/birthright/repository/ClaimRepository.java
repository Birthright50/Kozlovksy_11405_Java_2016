package com.birthright.repository;

import com.birthright.entity.Claim;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Birthright on 06.05.2016.
 */
public interface ClaimRepository extends PagingAndSortingRepository<Claim, Long> {
    List<Claim> findByUserId(Long user_id, Sort sort);
}
