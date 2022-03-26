package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;


@Dao
public interface DrugDAO {

    @Query("SELECT * FROM drug")
    LiveData<List<Drug>> getAll();

    @Query("SELECT * FROM drug WHERE drugNumber = :id")
    LiveData<Drug> get(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Drug drug);

    @Delete
    void delete(Drug... drugs);
}