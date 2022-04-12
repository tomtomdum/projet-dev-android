package com.example.inf1030_tp1.Data.Database;

import android.content.Context;

import androidx.annotation.RawRes;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.inf1030_tp1.Data.DAO.ClientDAO;
import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.Data.DAO.OrderDAO;
import com.example.inf1030_tp1.Data.DAO.OrderDrugMappingDAO;
import com.example.inf1030_tp1.Data.DataConverter.Converters;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.Models.OrderDrugMapping;
import com.example.inf1030_tp1.R;

import java.io.InputStream;
import java.util.concurrent.Executors;

@Database(
    entities = {
            Client.class,
            Drug.class,
            Order.class,
            OrderDrugMapping.class
    },
        version = 3
)
@TypeConverters({Converters.class})
public abstract class Db extends RoomDatabase {

    private static Db instance;
    public abstract ClientDAO clientDAO();
    public abstract DrugDAO drugDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDrugMappingDAO orderDrugMappingDAO();

    public static synchronized Db instance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    Db.class, "pharma-database")
                    .addCallback(new Callback() {
                        public void onCreate (SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor()
                                    .execute(() -> iniSchema(db,context));
                        }})
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return  instance;
    }

    private static void iniSchema(SupportSQLiteDatabase db, Context context) {
        try {
            loadSQLRaw(db, context, R.raw.drug);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private static void loadSQLRaw(SupportSQLiteDatabase helper, Context context, @RawRes int sqlRaw) {
        new Thread(()->{
            try {
                InputStream is = context.getResources().openRawResource(sqlRaw);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String sql = new String(buffer, "UTF-8");
                helper.execSQL(sql);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }


}
