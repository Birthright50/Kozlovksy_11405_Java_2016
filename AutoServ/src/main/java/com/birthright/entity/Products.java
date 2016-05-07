package com.birthright.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by birthright on 07.05.16.
 */
@Entity
public class Products {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private AutoModel autoModel;

    private List<OrdersProducts> ordersProductsList;

    @OneToMany(mappedBy = "products")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<OrdersProducts> getOrdersProductsList() {
        return ordersProductsList;
    }

    public void setOrdersProductsList(List<OrdersProducts> ordersProductsList) {
        this.ordersProductsList = ordersProductsList;
    }

    public Products() {
    }

    public Products(String name, String description, Integer price, AutoModel autoModel) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.autoModel = autoModel;
    }

    public void setAutoModel(AutoModel autoModel) {
        this.autoModel = autoModel;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public AutoModel getAutoModel() {
        return autoModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        Products products = (Products) o;

        if (id != null ? !id.equals(products.id) : products.id != null) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
