package com.acme.acmetrade.domain;

public class OrdersByStatus {
    private int openOrders;
    private int cancelledOrders;
    private int fulfilledOrders;

    public int getOpenOrders() {
        return openOrders;
    }

    public void setOpenOrders(int openOrders) {
        this.openOrders = openOrders;
    }

    public int getCancelledOrders() {
        return cancelledOrders;
    }

    public void setCancelledOrders(int cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }

    public int getFulfilledOrders() {
        return fulfilledOrders;
    }

    public void setFulfilledOrders(int fulfilledOrders) {
        this.fulfilledOrders = fulfilledOrders;
    }
}
