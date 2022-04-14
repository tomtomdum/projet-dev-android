package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.inf1030_tp1.Data.Enum.Role;

import java.util.UUID;

@Entity(foreignKeys = {@ForeignKey(entity = Client.class,
        parentColumns = "id",
        childColumns = "clientId",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Pharmacist.class,
                parentColumns = "id",
                childColumns = "pharmacistId",
                onDelete = ForeignKey.CASCADE)
})
public class User {
    @NonNull
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String username;
    private String password;
    @Ignore
    private Enum<Role> role;
    private String clientId;
    private String pharmacistId;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
        this.role = role;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return clientId;
    }

    public void setUserId(String userId) {
        this.clientId = userId;
    }
}
