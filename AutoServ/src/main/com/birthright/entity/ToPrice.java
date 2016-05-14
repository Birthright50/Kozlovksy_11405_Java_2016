package com.birthright.entity;

import javax.persistence.*;

/**
 * Created by birthright on 07.05.16.
 */
@Entity
@Table(name = "to_price", schema = "public", catalog = "postgres")
public class ToPrice {
    private Long id;
    private Integer price;
    private AutoModel autoModel;

    public ToPrice() {
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public AutoModel getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(AutoModel autoModel) {
        this.autoModel = autoModel;
    }

    public ToPrice(Integer price, AutoModel autoModel) {
        this.price = price;
        this.autoModel = autoModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "to_price_id_seq")
    @SequenceGenerator(name = "to_price_id_seq", sequenceName = "to_price_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToPrice toPrice = (ToPrice) o;

        if (id != null ? !id.equals(toPrice.id) : toPrice.id != null) return false;
        if (price != null ? !price.equals(toPrice.price) : toPrice.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
