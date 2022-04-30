package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.Models.OrderDrugs;

import java.util.List;
import java.util.Map;

@Dao
public interface OrderDrugsDAO {
//    @Query("SELECT * FROM `OrderDrugs`")
//    LiveData<Map<Drug, Integer>> getAll();

    @Query("SELECT * FROM 'OrderDrugs' WHERE id = :id")
    LiveData<OrderDrugs> get(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OrderDrugs orderDrug);

    @Delete
    void delete(OrderDrugs... orderDrugs);
}
