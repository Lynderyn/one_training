package com.acme.acmetrade.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class MarketOrder {

    @Id
    private String id;

    @NotNull
    private OrderSide side;

    @NotNull
    private OrderType type;

    @Min(value = 1, message = "Number of shares is required and has to be greater than 0")
    private int originalShares;

    private int remainingShares;

    @NotNull
    private String ticker;

    @NotNull
    private double price;

    private OrderStatus status;

    @NotNull
    private String traderId;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date updatedAt;

    public MarketOrder() {};

    public MarketOrder(String id, OrderSide side, OrderType type, int originalShares, int remainingShares, String ticker, double price, OrderStatus status, String traderId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.side = side;
        this.type = type;
        this.originalShares = originalShares;
        this.remainingShares = remainingShares;
        this.ticker = ticker;
        this.price = price;
        this.status = status;
        this.traderId = traderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
        this.status = OrderStatus.OPEN;
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

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public int getOriginalShares() {
        return originalShares;
    }

    public void setOriginalShares(int originalShares) {
        this.originalShares = originalShares;
    }

    public int getRemainingShares() {
        return remainingShares;
    }

    public void setRemainingShares(int remainingShares) {
        this.remainingShares = remainingShares;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
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

    public OrderStatus getStatus() { return status; }

    public void setStatus(OrderStatus status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketOrder that = (MarketOrder) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
