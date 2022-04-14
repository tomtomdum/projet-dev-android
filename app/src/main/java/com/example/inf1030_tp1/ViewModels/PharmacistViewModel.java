package com.example.inf1030_tp1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.PharmacistRepository;
import com.example.inf1030_tp1.Models.Pharmacist;

import java.util.List;

public class PharmacistViewModel extends AndroidViewModel {

    private LiveData<List<Pharmacist>> pharmacists;
    private PharmacistRepository pharmaRepo;

    public PharmacistViewModel(Application application) {
        super(application);
        pharmaRepo = new PharmacistRepository(application);
    }

    public LiveData<List<Pharmacist>> liveAll(){
        if(pharmacists != null){
            pharmacists = pharmaRepo.getPharmacists();
        }
        return pharmacists;
    }

    public void save(Pharmacist pharmacist, Runnable completion){pharmaRepo.insert(completion, pharmacist);}
}
