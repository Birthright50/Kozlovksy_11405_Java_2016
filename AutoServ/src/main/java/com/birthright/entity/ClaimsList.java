package com.birthright.entity;

import java.util.List;

/**
 * Created by birthright on 28.05.16.
 */
public class ClaimsList {
    private List<Claim> claimList;

    public ClaimsList() {
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }

    public ClaimsList(List<Claim> claimList) {

        this.claimList = claimList;
    }
}
