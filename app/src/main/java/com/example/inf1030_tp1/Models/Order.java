package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.UUID;

public class Order {

    @NonNull
    @PrimaryKey
    private String id;
    private List<Drug> drugs;

    public Order(){
        super();
        id = UUID.randomUUID().toString();
    }

    @NonNull
    public String getId() {
        return id;
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
