package com.birthright.service;


import com.birthright.entity.Claim;
import com.birthright.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Birthright on 06.05.2016.
 */
@Component
@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    public void saveClaim(Claim claim) {
        claimRepository.save(claim);
    }

    public List<Claim> findByUserId(Long user_id) {
        return claimRepository.findByUserId(user_id, new Sort(Sort.Direction.ASC, "status"));
    }

    public void deleteClaimById(Long id) {
        claimRepository.delete(id);
    }

    public List<Claim> findAll() {
        Iterable<Claim> iterable = claimRepository.findAll();
        List<Claim> claims = new ArrayList<>();
        iterable.forEach(claims::add);
        return claims;
    }
    public Claim findById(Long id){
        return claimRepository.findOne(id);
    }


}
