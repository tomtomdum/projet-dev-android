package com.example.inf1030_tp1.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.SyncRepository;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class SyncViewModel extends AndroidViewModel {

    private SyncRepository repo ;
    private LiveData<List<Drug>> drugs;

    public SyncViewModel(Application app){
        super(app);
        repo = new SyncRepository(app);

    }

    public void requestSync(Class<?> entity){
        repo.requestSync(entity.getSimpleName().toLowerCase());
    }

}