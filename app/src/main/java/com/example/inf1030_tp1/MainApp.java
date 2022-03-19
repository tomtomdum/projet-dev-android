package com.example.inf1030_tp1;

import android.content.Context;
import android.content.Intent;

import androidx.multidex.MultiDexApplication;

import com.example.inf1030_tp1.Data.Database.Db;

import java.util.HashMap;

public class MainApp extends MultiDexApplication {

    // todo finish implementation
    private Db db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Db.instance(this);
//
//        tasks = new HashMap<>();
//        initChannel();
//        Intent intent = new Intent(this, SyncService.class);
//        bindService(intent, serviceStarter, Context.BIND_AUTO_CREATE);
//        subscribe();

    }
    public Db getDb() { return db; }
}
