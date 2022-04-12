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
    @Query("SELECT * FROM [order]")
    LiveData<List<Order>> getAll();

    @Query("SELECT * FROM [order] WHERE id = :id")
    LiveData<Order> get(long id);

    @Query("SELECT * FROM [order] WHERE OrderName = :mOrderName")
    LiveData<Order> getORderName(long mOrderName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Order order);

    @Delete
    void delete(Order... order);
}
