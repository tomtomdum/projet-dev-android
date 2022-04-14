package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.ArrayList;
import java.util.UUID;

@Entity
public class Conversation {

    @NonNull
    @PrimaryKey
    private String id = UUID.randomUUID().toString();


    public Conversation() {}

    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
