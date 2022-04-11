package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Message;

import java.util.List;

@Dao
public interface MessageDAO {

    @Query("SELECT * FROM message WHERE id = :id")
    LiveData<Message> get(long id);

    @Query("SELECT * FROM message")
    LiveData<List<Message>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Message... message);

    @Delete
    void delete(Message... message);
}
