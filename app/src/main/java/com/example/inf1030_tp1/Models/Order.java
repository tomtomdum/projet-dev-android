package com.example.inf1030_tp1.Models;


import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {

    @NonNull
    @PrimaryKey
    private String id;
    private String mOrderName;
    private ArrayList<Drug> drugs = new ArrayList<>();
    private Map<Drug, Integer> drugQuantity = new HashMap<>();



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

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    public void addDrug(Drug drug){
        drugs.add(drug);
    }

    public int getDrugQuantity(Drug drug) {
       return drugQuantity.get(drug);
    }

    public void setDrugQuantity(Drug drug, int quantity) {
        drugQuantity.put(drug,quantity);
    }

    public boolean itemIsInTheList(Drug drug){
        for (Drug currentDrug: drugs) {
            if(currentDrug.equals(drug))
                return true;
        }
        return false;
    }
}