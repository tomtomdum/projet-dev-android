package com.example.inf1030_tp1.Data.Database;

import android.content.Context;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.inf1030_tp1.Data.DAO.ClientDAO;
import com.example.inf1030_tp1.Data.DAO.ConversationDAO;
import com.example.inf1030_tp1.Data.DAO.DrugDAO;
import com.example.inf1030_tp1.Data.DAO.MessageDAO;
import com.example.inf1030_tp1.Data.DAO.PharmacistDAO;
import com.example.inf1030_tp1.Data.DAO.PharmacyDAO;
import com.example.inf1030_tp1.Data.DAO.UserDAO;
import com.example.inf1030_tp1.Data.DAO.OrderDAO;
import com.example.inf1030_tp1.Data.DataConverter.Converters;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.Models.Message;
import com.example.inf1030_tp1.Models.Pharmacist;
import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.Models.User;
import com.example.inf1030_tp1.R;

import java.io.InputStream;
import java.util.concurrent.Executors;

@Database(
    entities = {
            Client.class,
            Drug.class,
            Message.class,
            Conversation.class,
            User.class,
            Pharmacist.class,
            Pharmacy.class
            Order.class,
    },
        version = 13
)
@TypeConverters({Converters.class})
public abstract class Db extends RoomDatabase {

    private static Db instance;
    public abstract ClientDAO clientDAO();
    public abstract DrugDAO drugDAO();
    public abstract MessageDAO messageDAO();
    public abstract ConversationDAO conversationDAO();
    public abstract UserDAO userDAO();
    public abstract PharmacistDAO pharmacistDAO();
    public abstract PharmacyDAO pharmacyDAO();
    public abstract OrderDAO orderDAO();

    public static synchronized Db instance(Context context){
        if(instance == null) {
            Log.i("info", "jsuis tannéé");
            instance = Room.databaseBuilder(context,
                    Db.class, "pharma-database")
                    .addCallback(new Callback() {
                        public void onCreate (SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Log.i("info", "PLS PASS HERE...");
                            Executors.newSingleThreadScheduledExecutor()
                                    .execute(() -> iniSchema(db,context));
                        }})
                    .fallbackToDestructiveMigration()
                    .build();
//            instance = Room.databaseBuilder(context,
//                    Db.class, "pharma-database")
//                    .addCallback(new Callback() {
//                        public void onCreate (SupportSQLiteDatabase db) {
//                            super.onCreate(db);
//                            Executors.newSingleThreadScheduledExecutor()
//                                    .execute(() -> iniSchema(db,context));
//                        }}).build();

        }
        return  instance;
    }

    private static void iniSchema(SupportSQLiteDatabase db, Context context) {
        try {
            Log.i("info", "Load sql file...");
            loadSQLRaw(db, context, R.raw.drug);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private static void loadSQLRaw(SupportSQLiteDatabase helper, Context context, @RawRes int sqlRaw) {
        new Thread(()->{
            try {
                Log.i("info", "HEYHEYHEYHEY");
                InputStream is = context.getResources().openRawResource(sqlRaw);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);

                String sql = new String(buffer, "UTF-8");
                helper.execSQL(sql);
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }


}
