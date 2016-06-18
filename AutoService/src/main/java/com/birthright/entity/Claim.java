package com.birthright.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Birthright on 05.05.2016.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "user_id")
public class Claim implements Serializable {
    private Long id;
    private Timestamp fDate;
    private String reason;
    private String status;
    private String response;
    private Users user;
    private Integer sum;

    public Claim(Timestamp fDate, String reason, String status, Users user) {
        this.fDate = fDate;
        this.reason = reason;
        this.status = status;
        this.response = "";
        this.user = user;
        sum = 0;
    }

    public Claim() {
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", fDate=" + fDate +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", response='" + response + '\'' +
                ", user=" + user +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "claim_id_seq")
    @SequenceGenerator(name = "claim_id_seq", sequenceName = "claim_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "f_date", nullable = false)
    public Timestamp getfDate() {
        return fDate;
    }

    public void setfDate(Timestamp fDate) {
        this.fDate = fDate;
    }

    @Basic
    @Column(name = "reason", nullable = false, length = -1)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "status", nullable = false, length = -1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "response", length = -1)
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Claim claim = (Claim) o;

        if (id != null ? !id.equals(claim.id) : claim.id != null) return false;
        if (fDate != null ? !fDate.equals(claim.fDate) : claim.fDate != null) return false;
        if (reason != null ? !reason.equals(claim.reason) : claim.reason != null) return false;
        if (status != null ? !status.equals(claim.status) : claim.status != null) return false;
        if (response != null ? !response.equals(claim.response) : claim.response != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fDate != null ? fDate.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "sum")
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
