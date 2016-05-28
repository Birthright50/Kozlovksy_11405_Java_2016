package entity;

import java.util.List;

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
