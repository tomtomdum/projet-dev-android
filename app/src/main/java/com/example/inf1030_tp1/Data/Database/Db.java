package com.example.inf1030_tp1.Data.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.inf1030_tp1.Data.DAO.ClientDAO;
import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.Data.DAO.SyncInfoDAO;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Drug;

@Database(
    entities = {
            Client.class,
            Drug.class
    },
        version = 1
)
public abstract class Db extends RoomDatabase {
    private static Db instance;
    public abstract ClientDAO clientDAO();
    public abstract DrugDAO drugDAO();
    public abstract SyncInfoDAO syncInfoDAO();



    public static synchronized Db instance(Context context){
        if(instance != null) {
            return instance;
        }
        instance = Room.databaseBuilder(
                context.getApplicationContext(),
                Db.class,
                "pharma-database"
                )
//                .fallbackToDestructiveMigration()
                .build();
        return instance;
    }
}
