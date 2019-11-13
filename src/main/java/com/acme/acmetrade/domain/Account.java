package com.acme.acmetrade.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private String id;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private String traderId;

    @NotNull
    private Currency currency;

    private double balance;

    private List<String> positionIds;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Account() {
    }

    public Account(String id, @NotBlank String accountNumber, @NotBlank String traderId, @NotNull Currency currency, double balance, List<String> positionIds, Date createdAt, Date updatedAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.traderId = traderId;
        this.currency = currency;
        this.balance = balance;
        this.positionIds = positionIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(List<String> positionIds) {
        this.positionIds = positionIds;
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
}
