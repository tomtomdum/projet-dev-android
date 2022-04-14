package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

@Entity(foreignKeys = {@ForeignKey(entity = Pharmacy.class,
                parentColumns = "id",
                childColumns = "pharmacyId")
})
public class Pharmacist implements Serializable {

    @NonNull
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String pharmacyId;
    private String firstName;
    private String lastName;

    public Pharmacist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getPharmacy() {
        return pharmacyId;
    }

    public void setPharmacy(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
