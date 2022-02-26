package com.example.inf1030_tp1.Models;

import androidx.room.PrimaryKey;

public class Drug {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;

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
