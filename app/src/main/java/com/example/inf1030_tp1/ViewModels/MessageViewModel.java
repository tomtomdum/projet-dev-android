package com.example.inf1030_tp1.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.MessageRepository;
import com.example.inf1030_tp1.Models.Message;

import java.util.List;

public class MessageViewModel extends AndroidViewModel {

    private MessageRepository repo;
    private LiveData<List<Message>> messages;

    public MessageViewModel(Application app){
        super(app);
        repo = new MessageRepository(app);
    }

    public LiveData<List<Message>> liveAll(){
        if(messages == null) {
            messages = repo.getAllMessage();
        }
        return  messages;
    }

    public void save(Message message, Runnable completion){
        repo.insert(completion, message);
    }
}
