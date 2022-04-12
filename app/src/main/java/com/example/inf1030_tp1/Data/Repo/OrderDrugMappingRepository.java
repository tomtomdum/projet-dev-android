package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.Data.DAO.OrderDrugMappingDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.OrderDrugMapping;

import java.util.List;

public class OrderDrugMappingRepository {

    private OrderDrugMappingDAO orderDrugMappingDAO;
    private LiveData<List<OrderDrugMapping>> ODMs;
    private MainApp app;

    public OrderDrugMappingRepository(Application app){
        this.app = (MainApp) app;
        orderDrugMappingDAO = this.app.getDb().orderDrugMappingDAO();
    }

    public LiveData<List<OrderDrugMapping>> getAllOrdersMapping(){
        if(ODMs == null){
            ODMs = orderDrugMappingDAO.getAll();
        }
        return ODMs;
    }

    public LiveData<OrderDrugMapping> get(long id){ return orderDrugMappingDAO.get(id); }

    public void insert(Runnable completion, OrderDrugMapping ODM){
        Thread t = new Thread(() -> {
            orderDrugMappingDAO.insert(ODM);
        });
        t.start();
    }

    public void delete(OrderDrugMapping... ODMS){ orderDrugMappingDAO.delete(ODMS); }
}
