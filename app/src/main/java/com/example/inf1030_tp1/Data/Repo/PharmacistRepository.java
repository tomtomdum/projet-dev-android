package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.PharmacistDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Pharmacist;

import java.util.List;

public class PharmacistRepository {

    private LiveData<List<Pharmacist>> pharmacists;
    private PharmacistDAO pharmacistDao;
    private MainApp mainApp;

    public PharmacistRepository(Application app){
        mainApp = (MainApp) app;
        pharmacistDao = this.mainApp.getDb().pharmacistDAO();
    }

    public LiveData<List<Pharmacist>> getPharmacists(){
        if(pharmacists == null){
            Thread t = new Thread(() -> pharmacistDao.getAll());
            t.start();
        }
        return pharmacists;
    }

    public LiveData<Pharmacist> getPharmacist(String id){
        return pharmacistDao.get(id);
    }

    public void insert(Runnable completion, Pharmacist pharmacist){
        Thread t = new Thread(() -> {
            pharmacistDao.insert(pharmacist);
            completion.run();
        });
        t.start();
    }

    public void delete(Runnable completion, Pharmacist pharmacist){
        Thread t = new Thread(() -> {
            pharmacistDao.delete(pharmacist);
            completion.run();
        });
        t.start();
    }

}
