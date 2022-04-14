package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Data.DAO.ClientDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Conversation;

import java.util.List;

public class ClientRepository {
    private ClientDAO clientDao;
    private LiveData<List<Client>> clients;
    private MainApp app;

    public ClientRepository(Application context){
        app = (MainApp) context;
        clientDao = app.getDb().clientDAO();
    }

    public LiveData<List<Client>> getAllClients() {
        if(clients == null){
            clients = clientDao.getAll();
        }
        return clients;
    }

    public LiveData<Client> getById(long id){
        return clientDao.get(id);
    }

    public void insert(Runnable completion, Client client){
        Log.i("info", "TEST2");
        Thread t = new Thread(() -> {
            Log.i("info", "INSERT CLIENT");
            clientDao.insert(client);
        });
        t.start();
        // todo create a callback to inform the user if it worked or not
    }

    public void delete(Client... clients){
        Thread t = new Thread(() -> {
            clientDao.delete((clients));
        });
        t.start();
        // todo create a callback to inform the user if it worked or not

    }

}
