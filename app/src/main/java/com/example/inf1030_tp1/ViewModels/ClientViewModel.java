package com.example.inf1030_tp1.ViewModels;

import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.ClientRepository;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Conversation;

import java.util.List;

public class ClientViewModel extends AndroidViewModel {

    private LiveData<List<Client>> clients;
    private ClientRepository clientRepository;

    public ClientViewModel(MainApp app){
        super(app);
        clientRepository = new ClientRepository(app);
    }

    public LiveData<List<Client>> liveAll(){
        if(clients == null){
            clients = clientRepository.getAllClients();
        }
        return clients;
    }

    public void save(Client client, Runnable completion){
        Log.i("info", "TEST1");
        clientRepository.insert(completion, client);
    }
}
