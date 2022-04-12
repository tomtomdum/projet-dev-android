package com.example.inf1030_tp1.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.DrugRepository;
import com.example.inf1030_tp1.Data.Repo.OrderRepository;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {
    private OrderRepository repo;
    private LiveData<List<Order>> orders;

    public OrderViewModel(Application app){
        super(app);
        repo = new OrderRepository(app);
    }

    public LiveData<List<Order>> liveAll(){
        if(orders == null) {
            orders = repo.getAllOrders();
        }
        return  orders;
    }

    public void save(Order order, Runnable completion){
        repo.insert(completion, order);
    }

}
