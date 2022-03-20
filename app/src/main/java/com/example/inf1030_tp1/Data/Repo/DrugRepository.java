package com.example.inf1030_tp1.Data.Repo;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Data.DAO.DrugDao;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugRepository {
    // todo finish the implementation with threads
    private DrugDao drugDao;
    private LiveData<List<Drug>> drugs;
    private MainApp app;

    public DrugRepository(Application app){
        this.app = (MainApp) app;
        drugDao = this.app.getDb().drugDao();
    }

    public LiveData<List<Drug>> getAllDrugs(){
        if(drugs == null){
            drugs = drugDao.getAll();
        }
        return drugs;
    }

    public LiveData<Drug> get(long id){ return drugDao.get(id); }

    public void insert(Runnable completion, Drug drug){
        Thread t = new Thread(() -> {
           drugDao.insert(drug);
            Log.i("info", "TABARNAQUEEEEEEE");
            Log.i("info", "This is a test "+drug.getId());
        });
        t.start();
//        app.dbPost(() -> {
////            Log.i("info", "TABARNAQUEEEEEEE");
//            drugDao.insert(drugs);
//        });
//        app.dbPost(()->{
//            Log.i("info", "TABARNAQUEEEEEEE");
//            drugDao.insert(drugs);
//            if(completion != null) {
//                new Handler(Looper.getMainLooper()).post(completion);
//            }
//        });

    }

    public void delete(Drug... drugs){ drugDao.delete(drugs); }
}
