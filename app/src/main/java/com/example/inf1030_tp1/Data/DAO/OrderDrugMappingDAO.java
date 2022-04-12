package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.OrderDrugMapping;

import java.util.List;
@Dao
public interface OrderDrugMappingDAO {
    @Query("SELECT * FROM [orderDrugMapping]")
    LiveData<List<OrderDrugMapping>> getAll();

    @Query("SELECT * FROM [orderDrugMapping] WHERE mapId = :id")
    LiveData<OrderDrugMapping> get(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OrderDrugMapping orderDrugMapping);

    @Delete
    void delete(OrderDrugMapping... orderDrugMapping);
}
