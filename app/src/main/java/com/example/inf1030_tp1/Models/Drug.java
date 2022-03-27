package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Drug {

//    catnumber,drugnumber, dci,dosage,form,reference,cases,posts,centers,eps1,eps2, eps3,createdBy,lastUpdatedBy,status

    @NonNull
    @PrimaryKey
    private int drugNumber;
    private int catNumber;
    private String dci;
    private String dosage;
    private String reference;
    private String form;
    private int cases;
    private int posts;
    private int centers;
    private int eps1;
    private int eps2;
    private int eps3;
    private String createdBy;
    private String lastUpdatedBy;
    private int status;

    public Drug() {
        super();
    }

    public int getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(int drugNumber) {
        this.drugNumber = drugNumber;
    }

    public int getCatNumber() {
        return catNumber;
    }

    public void setCatNumber(int catNumber) {
        this.catNumber = catNumber;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getCenters() {
        return centers;
    }

    public void setCenters(int centers) {
        this.centers = centers;
    }

    public int getEps1() {
        return eps1;
    }

    public void setEps1(int eps1) {
        this.eps1 = eps1;
    }

    public int getEps2() {
        return eps2;
    }

    public void setEps2(int eps2) {
        this.eps2 = eps2;
    }

    public int getEps3() {
        return eps3;
    }

    public void setEps3(int eps3) {
        this.eps3 = eps3;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
