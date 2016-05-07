package com.birthright.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by birthright on 07.05.16.
 */
public class OrdersProductsPK implements Serializable {
    private Long ordersId;
    private Long productsId;

    @Column(name = "orders_id", insertable = false, updatable = false)
    @Id
    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    @Column(name = "products_id", insertable = false, updatable = false)
    @Id
    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersProductsPK that = (OrdersProductsPK) o;

        if (ordersId != null ? !ordersId.equals(that.ordersId) : that.ordersId != null) return false;
        if (productsId != null ? !productsId.equals(that.productsId) : that.productsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordersId != null ? ordersId.hashCode() : 0;
        result = 31 * result + (productsId != null ? productsId.hashCode() : 0);
        return result;
    }
}
