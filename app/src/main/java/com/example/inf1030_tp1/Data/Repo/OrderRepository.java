package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.OrderDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Order;

import java.util.List;

public class OrderRepository {
    private OrderDAO orderDAO;
    private LiveData<List<Order>> orders;
    private MainApp app;

    public OrderRepository(Application app){
        this.app = (MainApp) app;
        orderDAO = this.app.getDb().orderDAO();
    }

    public LiveData<List<Order>> getAllOrders(){
        if(orders == null){
            orders = orderDAO.getAll();
        }
        return orders;
    }

    public LiveData<Order> get(long id){ return orderDAO.get(id); }

    public void insert(Runnable completion, Order orders){
        Thread t = new Thread(() -> {
            orderDAO.insert(orders);
        });
        t.start();
    }

    public void delete(Order... orders){ orderDAO.delete(orders); }
}
