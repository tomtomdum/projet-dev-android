package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.inf1030_tp1.Models.Order;

import java.util.List;
@Dao
public interface OrderDAO {
    @Query("SELECT * FROM `Order`")
    LiveData<List<Order>> getAll();

    @Query("SELECT * FROM `Order`")
    List<Order> getAlla();

    @Query("SELECT * FROM 'Order' WHERE id = :id")
    LiveData<Order> get(long id);

    @Query("SELECT * FROM 'Order' WHERE mOrderName = :mOrderName")
    LiveData<Order> getMOrderName(long mOrderName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Order order);

    @Delete
    void delete(Order... order);
}
