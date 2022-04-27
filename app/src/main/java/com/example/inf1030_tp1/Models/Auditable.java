package com.example.inf1030_tp1.Models;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Auditable {
    @NonNull
    private LocalDateTime created;
    @NonNull
    private LocalDateTime updated;

    private boolean needUpdate;
    private boolean deleted;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Auditable(){
        created = LocalDateTime.now();
        updated = LocalDateTime.now();
    }
    public @NonNull LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(@NonNull LocalDateTime created) {
        this.created = created;
    }

    public @NonNull LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(@NonNull LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isNeedUpdate() {
        return needUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        this.needUpdate = needUpdate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}