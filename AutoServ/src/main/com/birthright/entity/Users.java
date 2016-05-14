package com.birthright.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Birthright on 28.04.2016.
 */
@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String password;
    private String email;
    private Boolean enabled;
    private String name;
    private String lastname;
    private String userRole;
    private String secondName;
    private String telephone;
    private String automobile;
    private List<Claim> claims;
    private List<Orders> ordersList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public Users() {
    }

    public Users(String password, String email, Boolean enabled, String name, String lastname, String userRole) {
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.name = name;
        this.lastname = lastname;
        this.userRole = userRole;
        this.automobile = "";
        this.telephone = "";
        this.secondName = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = -1)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users user = (Users) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "user_role", nullable = false, length = -1)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "second_name", nullable = true, length = -1)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = -1)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "automobile", nullable = true, length = -1)
    public String getAutomobile() {
        return automobile;
    }

    public void setAutomobile(String automobile) {
        this.automobile = automobile;
    }
}
