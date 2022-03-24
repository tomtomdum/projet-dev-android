package com.example.inf1030_tp1.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity
public class Account extends Auditable{
    @PrimaryKey()
    private int id;
    private  String username;
    private  String cypheredPassword;
    private  String token;
    private LocalDateTime expire;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Account(){
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCypheredPassword() {
        return cypheredPassword;
    }

    public void setCypheredPassword(String cypheredPassword) {
        this.cypheredPassword = cypheredPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpire() {
        return expire;
    }

    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }
}
