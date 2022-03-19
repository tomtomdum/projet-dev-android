package com.example.inf1030_tp1.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Drug {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;

    public Drug(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void setId(long id) { this.id = id; }

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
