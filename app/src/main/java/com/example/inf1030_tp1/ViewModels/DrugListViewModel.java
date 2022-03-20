package com.example.inf1030_tp1.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inf1030_tp1.Data.Repo.DrugRepository;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugListViewModel extends AndroidViewModel {

    private DrugRepository repo;
    private LiveData<List<Drug>> drugs;

    public DrugListViewModel(Application app){
        super(app);
        repo = new DrugRepository(app);
    }

    public LiveData<List<Drug>> liveAll(){
        if(drugs == null) {
            drugs = repo.getAllDrugs();
        }
        return  drugs;
    }

    public void save(Drug drug, Runnable completion){
        repo.insert(completion, drug);
    }
}
