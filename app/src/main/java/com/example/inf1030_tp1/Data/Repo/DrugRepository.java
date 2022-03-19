package com.example.inf1030_tp1.Data.Repo;
import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class DrugRepository {
    // todo finish the implementation
    private DrugDAO drugDao;
    private LiveData<List<Drug>> drugs;
    private MainApp app;

    DrugRepository(Application context){
        app = (MainApp) context;
        drugDao = app.getDb().drugDAO();
    }
}
