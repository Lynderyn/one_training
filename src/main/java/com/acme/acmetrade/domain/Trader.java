package com.acme.acmetrade.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;

@Entity
public class Trader {

    @Id
    private String id;


    @Pattern(regexp = "[A-Za-z]*", message = "Bad Name")
    private String fName;

    @Pattern(regexp = "[A-Za-z]*", message = "Bad Name")
    private String lName;

    @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "Bad Phone")
    private String phone;

    @Email
    private String email;


    @NotNull
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date updatedAt;

    public Trader() {};

    public Trader(String id, @Pattern(regexp = "[A-Za-z]*") String fName, @Pattern(regexp = "[A-Za-z]*") String lName, @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}") String phone, @NotNull String email, @Pattern(regexp = "[0-9]* [A-Za-z]*") String address, List<Account> accounts, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.accounts = accounts;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trader trader = (Trader) o;
        return id.equals(trader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
