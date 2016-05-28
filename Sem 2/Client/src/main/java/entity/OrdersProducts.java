package entity;

import javax.persistence.*;

/**
 * Created by birthright on 27.05.16.
 */
@Entity
@Table(name = "orders_products", schema = "public", catalog = "postgres")
public class OrdersProducts {
    private Integer count;
    private Long id;
    private Products productsByProductsId;

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Id
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

        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = count != null ? count.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false)
    public Products getProductsByProductsId() {
        return productsByProductsId;
    }

    public void setProductsByProductsId(Products productsByProductsId) {
        this.productsByProductsId = productsByProductsId;
    }
}
