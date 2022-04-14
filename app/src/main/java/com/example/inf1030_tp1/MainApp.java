package com.example.inf1030_tp1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.example.inf1030_tp1.Data.Database.Db;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp extends MultiDexApplication {

    // todo finish implementation
    private Db db;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

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

    public void dbPost(Runnable dbTask) {
        executorService.submit(dbTask);
    }
}
