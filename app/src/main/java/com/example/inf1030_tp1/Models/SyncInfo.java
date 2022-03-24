package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SyncInfo extends Auditable{
    @PrimaryKey
    @NonNull
    private String entity;
    private boolean isDirty;
    public  SyncInfo(){
        super();
    }

    public @NonNull String getEntity() {
        return entity;
    }

    public void setEntity(@NonNull String entity) {
        this.entity = entity;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }
}
