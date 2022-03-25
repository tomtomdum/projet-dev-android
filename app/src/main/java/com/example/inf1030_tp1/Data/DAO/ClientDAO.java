package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Client;

import java.util.List;

@Dao
public interface ClientDAO {
    @Query("SELECT * FROM client")
    LiveData<List<Client>> getAll();

    @Query("SELECT * FROM client WHERE id = :id")
    LiveData<Client> get(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Client... client);

    @Delete
    void delete(Client... client);
}
