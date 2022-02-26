//package com.example.inf1030_tp1.Models.DAO;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import com.example.inf1030_tp1.Models.Drug;
//
//import java.util.List;
//@Dao
//public interface DrugDAO {
//
//    @Query("SELECT * FROM drug")
//    List<Drug> getall();
//
//    @Query("SELECT * FROM drug WHERE id = :id")
//    Drug get(long id);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(Drug... drugs);
//
//    @Delete
//    void delete(Drug... drugs);
//}
