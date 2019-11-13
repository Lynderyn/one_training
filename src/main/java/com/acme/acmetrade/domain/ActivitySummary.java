package com.acme.acmetrade.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActivitySummary {
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date lastOrderDate;

    private OrdersByStatus ordersByStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public OrdersByStatus getOrdersByStatus() {
        return ordersByStatus;
    }

    public void setOrdersByStatus(OrdersByStatus ordersByStatus) {
        this.ordersByStatus = ordersByStatus;
    }
}
