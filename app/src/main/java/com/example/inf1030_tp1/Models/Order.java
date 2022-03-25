package com.example.inf1030_tp1.Models;


import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.UUID;

public class Order {

    @NonNull
    @PrimaryKey
    private String id;
    private String mOrderName;
    private List<Drug> drugs;

    public Order(String mOrderName){
        super();
        id = UUID.randomUUID().toString();
        this.mOrderName = mOrderName;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getmOrderName() {
        return mOrderName;
    }

    public void setmOrderName(String mOrderName) {
        this.mOrderName = mOrderName;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;

    }
}