package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.PharmacyDAO;
import com.example.inf1030_tp1.Data.DAO.UserDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.Models.User;

import java.util.List;

public class PharmacyRepository {

    private PharmacyDAO pharmacyDao;
    private LiveData<List<Pharmacy>> pharmacies;
    private MainApp app;

    public PharmacyRepository(Application app){
        this.app = (MainApp) app;
        pharmacyDao = this.app.getDb().pharmacyDAO();
    }

    public LiveData<List<Pharmacy>> getUsers(){
        if(pharmacies == null){
            Thread t = new Thread(() -> pharmacies = pharmacyDao.getAll());
            t.start();
        }
        return pharmacies;
    }

    public LiveData<Pharmacy> get(String id){
        return pharmacyDao.get(id);
    }

    public void insert(Runnable completion, Pharmacy pharmacy) {
        Thread t = new Thread(() -> {
            pharmacyDao.insert(pharmacy);
            completion.run();
        });
        t.start();
    }

    public void delete(Runnable completion, Pharmacy pharmacy){
        Thread t =  new Thread(() -> {
            pharmacyDao.delete(pharmacy);
            completion.run();
        });
        t.start();
    }
}
