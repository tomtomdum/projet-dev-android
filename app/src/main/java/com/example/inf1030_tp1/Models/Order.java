package com.example.inf1030_tp1.Models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Entity
public class Order {

    @NonNull
    @PrimaryKey
    private String id;
    private String mOrderName;
//    @Ignore
    private ArrayList<Drug> drugs = new ArrayList<>();
    @Ignore
    private Map<Drug, Integer> drugQuantity = new HashMap<>();
    @Ignore
    private List<Pharmacy> mPharmacyList = new ArrayList<>();
    @Ignore
    public List<Pharmacy> getPharmacyList() {
        return mPharmacyList;
    }

    public void setPharmacyList(List<Pharmacy> pharmacyList) {
        mPharmacyList = pharmacyList;
    }

//    public Order(String mOrderName){
//        super();
//        id = UUID.randomUUID().toString();
//        this.mOrderName = mOrderName;
//    }
    public Order(){
        super();
        id = UUID.randomUUID().toString();
        this.generateOrderName();
    }
    @NonNull
    public String getId() {
        return id;
    }

    public String getMOrderName() {
        return mOrderName;
    }

    public void setMOrderName(String mOrderName) {
        this.mOrderName = mOrderName;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    public void addDrug(Drug drug){
        drugs.add(drug);
    }

    public void removeDrugs(){
        this.drugs.removeAll(this.drugs);
    }
    public void removeDrug(Drug drug){
        drugs.remove(drug);
        drugQuantity.remove(drug);
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

    private void generateOrderName(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.mOrderName = "ORDER_"+dtf.format(now);
    }
}