package com.example.inf1030_tp1.Data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.inf1030_tp1.Models.SyncInfo;

import java.util.List;

@Dao
public interface SyncInfoDAO {

    @Query("SELECT * FROM syncInfo")
    LiveData<List<SyncInfo>> getLiveAll();

    @Query("SELECT * FROM syncInfo WHERE entity = :entityName")
    LiveData<SyncInfo> getLive(String entityName);

    @Query("SELECT * FROM syncInfo WHERE entity = :entityName")
    SyncInfo get(String entityName);

    //    @Query("SELECT * FROM syncinfo WHERE isDirty")
    @Query("SELECT * FROM syncInfo WHERE isDirty")
    LiveData<List<SyncInfo>> getLiveDirty();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SyncInfo... productInfos);

    @Delete()
    void delete(SyncInfo... productInfos);

    @Update()
    void update(SyncInfo... syncInfos);
}
