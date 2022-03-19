package com.example.inf1030_tp1.ViewModels;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.inf1030_tp1.Data.Database.Db;
import com.example.inf1030_tp1.Data.Repo.DrugRepository;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugViewModel extends AndroidViewModel {

    private Drug currentDrug;
    private LiveData<List<Drug>> drugs;
    private DrugRepository repository;

    public DrugViewModel(MainApp app){
        super(app);
        repository = new DrugRepository(app);
    }

    public LiveData<List<Drug>> liveAll() {
        if(drugs == null){
            drugs = repository.getAllDrugs();
        }
        return drugs;
    }
}
