//package com.example.inf1030_tp1.Data.Repo;
//
//import android.app.Application;
//
//import androidx.lifecycle.LiveData;
//
//import com.example.inf1030_tp1.Data.DAO.OrderDrugsDAO;
//import com.example.inf1030_tp1.Data.DAO.PharmacyDAO;
//import com.example.inf1030_tp1.MainApp;
//import com.example.inf1030_tp1.Models.Drug;
//import com.example.inf1030_tp1.Models.Pharmacy;
//
//import java.util.List;
//import java.util.Map;
//
//public class OrderDrugsRepository {
//    private OrderDrugsDAO mOrderDrugsDAO;
//    private LiveData<Map<Drug, Integer>> drugQt;
//    private MainApp app;
//
//    public OrderDrugsRepository(Application app){
//        this.app = (MainApp) app;
//        mOrderDrugsDAO = this.app.getDb().orderDrugsDAO();
//    }
//
//    public LiveData<List<Pharmacy>> getUsers(){
//        if(pharmacies == null){
//            Thread t = new Thread(() -> drugQt = mOrderDrugsDAO.getAll());
//            t.start();
//        }
//        return pharmacies;
//    }
//
//    public LiveData<Pharmacy> get(String id){
//        return pharmacyDao.get(id);
//    }
//
//    public void insert(Runnable completion, Pharmacy pharmacy) {
//        Thread t = new Thread(() -> {
//            pharmacyDao.insert(pharmacy);
//            completion.run();
//        });
//        t.start();
//    }
//
//    public void delete(Runnable completion, Pharmacy pharmacy){
//        Thread t =  new Thread(() -> {
//            pharmacyDao.delete(pharmacy);
//            completion.run();
//        });
//        t.start();
//    }
//}
