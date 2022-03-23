package com.example.inf1030_tp1.Models;

public class DrugOrder {
    private long id;
    private String name;
    private String description;
    private int Quantity;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public DrugOrder(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
