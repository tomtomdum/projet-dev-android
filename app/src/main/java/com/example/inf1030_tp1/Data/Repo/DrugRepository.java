package com.example.inf1030_tp1.Data.Repo;
import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugRepository {
    // todo finish the implementation with threads
    private DrugDAO drugDao;
    private LiveData<List<Drug>> drugs;
    private MainApp app;

    public DrugRepository(MainApp app){
        this.app = app;
        drugDao = app.getDb().drugDAO();
    }

    public LiveData<List<Drug>> getAllDrugs(){
        if(drugs == null){
            drugs = drugDao.getAll();
        }
        return drugs;
    }

    public LiveData<Drug> get(long id){ return drugDao.get(id); }

    public void insert(Drug... drugs){ drugDao.insert(drugs); }

    public void delete(Drug... drugs){ drugDao.delete(drugs); }
}
