package com.example.inf1030_tp1.Models;

public class Order {
    private String mOrderName;

    public String getOrderName() {
        return mOrderName;
    }

    public void setOrderName(String mOrderName) {
        this.mOrderName = mOrderName;
    }

    public Order(String mOrderName) {
        this.mOrderName = mOrderName;
    }
}
