package com.example.inf1030_tp1.Data.Repo;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugRepository {
    // todo finish the implementation with threads
    private DrugDAO drugDao;
    private LiveData<List<Drug>> drugs;
    private MainApp app;

    public DrugRepository(Application app){
        this.app = (MainApp) app;
        drugDao = this.app.getDb().drugDAO();
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
