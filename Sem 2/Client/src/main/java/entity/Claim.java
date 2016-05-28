package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by birthright on 27.05.16.
 */
@Entity
@Table(name = "claim", schema = "public", catalog = "postgres")
public class Claim {
    private Long user_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    private Long id;
    private Timestamp fDate;
    private String reason;
    private String status;
    private String response;
    private Integer sum;
    private Users user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "f_date")
    public Timestamp getfDate() {
        return fDate;
    }

    public void setfDate(Timestamp fDate) {
        this.fDate = fDate;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Basic
    @Column(name = "sum")
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Claim that = (Claim) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fDate != null ? !fDate.equals(that.fDate) : that.fDate != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fDate != null ? fDate.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }


}
