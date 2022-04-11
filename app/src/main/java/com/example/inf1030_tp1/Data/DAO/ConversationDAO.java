package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.Models.Message;

import java.util.List;

@Dao
public interface ConversationDAO {

    @Query("SELECT * FROM conversation WHERE id = :id")
    LiveData<Conversation> get(String id);

    @Query("SELECT * FROM conversation")
    LiveData<List<Conversation>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Conversation... conversation);

    @Delete
    void delete(Conversation... conversation);
}
