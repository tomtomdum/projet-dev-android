package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Pharmacist;

import java.util.List;

@Dao
public interface PharmacistDAO {

    @Query("SELECT * FROM pharmacist")
    LiveData<List<Pharmacist>> getAll();

    @Query("SELECT * FROM pharmacist WHERE id = :id")
    LiveData<Pharmacist> get(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pharmacist... pharmacists);

    @Delete
    void delete(Pharmacist... pharmacists);
}
