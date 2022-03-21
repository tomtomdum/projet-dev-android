package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Drug {

    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String description;

    public Drug() {
        super();
        id = UUID.randomUUID().toString();
    }
    public void setId(@NonNull String id) { this.id = id; }

    @NonNull
    public String getId() {
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
