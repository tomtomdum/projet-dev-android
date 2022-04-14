package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.Models.User;

import java.util.List;

@Dao
public interface PharmacyDAO {

    @Query("SELECT * FROM pharmacy")
    LiveData<List<Pharmacy>> getAll();

    @Query("SELECT * FROM pharmacy WHERE id = :id")
    LiveData<Pharmacy> get(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pharmacy... pharmacy);

    @Delete
    void delete(Pharmacy... pharmacy);
}
