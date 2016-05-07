package com.birthright.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Birthright on 06.05.2016.
 */
@Entity
@Table(name = "auto_model", schema = "public", catalog = "postgres")
public class AutoModel {
    private Long id;
    private String name;
    private AutoBrand brand;
    private ToPrice price;
    private List<Products> products;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "autoModel")
    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "autoModel")
    public ToPrice getPrice() {
        return price;
    }

    public void setPrice(ToPrice priceList) {
        this.price = priceList;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "auto_brand_id", referencedColumnName = "id")
    public AutoBrand getBrand() {
        return brand;
    }

    public AutoModel() {
    }

    public void setBrand(AutoBrand brand) {
        this.brand = brand;
    }

    public AutoModel(String name, AutoBrand brand) {
        this.name = name;
        this.brand = brand;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_model_id_seq")
    @SequenceGenerator(name="auto_model_id_seq", sequenceName="auto_brand_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoModel autoModel = (AutoModel) o;

        if (id != null ? !id.equals(autoModel.id) : autoModel.id != null) return false;
        if (name != null ? !name.equals(autoModel.name) : autoModel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
