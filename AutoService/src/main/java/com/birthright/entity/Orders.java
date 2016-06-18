package com.birthright.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "postgres")
public class Orders implements Serializable {
    private Long id;
    private String status;
    private String address;
    private Timestamp fDate;
    private Integer sum;
    private Users users;
    private List<OrdersProducts> ordersProductsList;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<OrdersProducts> getOrdersProductsList() {
        return ordersProductsList;
    }

    public void setOrdersProductsList(List<OrdersProducts> ordersProductsList) {
        this.ordersProductsList = ordersProductsList;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_id_seq")
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

        Orders that = (Orders) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (fDate != null ? !fDate.equals(that.fDate) : that.fDate != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (fDate != null ? fDate.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }
}
