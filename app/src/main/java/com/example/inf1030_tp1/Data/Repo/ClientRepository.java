package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inf1030_tp1.Data.DAO.ClientDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Client;

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
        if(clients != null){
            clients = clientDao.getAll();
        }
        return clients;
    }

    public LiveData<Client> getById(long id){
        return clientDao.get(id);
    }

    public void insert(Client... client){
        // todo create a callback to inform the user if it worked or not
        clientDao.insert(client);
    }

    public void delete(Client... client){
        // todo create a callback to inform the user if it worked or not
        clientDao.delete((client));
    }

}
