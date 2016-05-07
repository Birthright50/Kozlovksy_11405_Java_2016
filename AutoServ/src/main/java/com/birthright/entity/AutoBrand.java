package com.birthright.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Birthright on 05.05.2016.
 */
@Entity
@Table(name = "auto_brand", schema = "public", catalog = "postgres")
public class AutoBrand {
    private Long id;
    private String name;
    private List<AutoModel> autoModels;

    public AutoBrand(String name) {
        this.name = name;
    }

    public AutoBrand() {
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand")
    public List<AutoModel> getAutoModels() {
        return autoModels;
    }

    public void setAutoModels(List<AutoModel> autoModels) {
        this.autoModels = autoModels;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_brand_id_seq")
    @SequenceGenerator(name="auto_brand_id_seq", sequenceName="auto_brand_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
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

        AutoBrand autoBrand = (AutoBrand) o;

        if (id != null ? !id.equals(autoBrand.id) : autoBrand.id != null) return false;
        if (name != null ? !name.equals(autoBrand.name) : autoBrand.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
