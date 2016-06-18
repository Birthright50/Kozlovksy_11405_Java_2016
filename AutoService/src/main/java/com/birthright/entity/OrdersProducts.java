package com.birthright.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by birthright on 13.05.16.
 */
@Entity
@Table(name = "orders_products", schema = "public", catalog = "postgres")

public class OrdersProducts implements Serializable {
    private Long ordersId;
    private Long productsId;
    private Integer count;
    private Long id;
    private Orders orders;
    private Products products;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public OrdersProducts() {
    }

    public OrdersProducts(Integer count, Orders orders, Products products) {
        this.count = count;
        this.orders = orders;
        this.products = products;
    }

    @Basic
    @Column(name = "orders_id", insertable = false, updatable = false)
    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    @Basic
    @Column(name = "products_id", insertable = false, updatable = false)
    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_products_id_seq")
    @SequenceGenerator(name = "orders_products_id_seq", sequenceName = "orders_products_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersProducts that = (OrdersProducts) o;

        if (ordersId != null ? !ordersId.equals(that.ordersId) : that.ordersId != null) return false;
        if (productsId != null ? !productsId.equals(that.productsId) : that.productsId != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordersId != null ? ordersId.hashCode() : 0;
        result = 31 * result + (productsId != null ? productsId.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
