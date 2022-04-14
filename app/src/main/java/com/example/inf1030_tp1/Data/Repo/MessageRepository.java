package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.MessageDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Message;

import java.util.List;

public class MessageRepository {
    // todo finish the implementation with threads
    private MessageDAO messageDao;
    private LiveData<List<Message>> messages;
    private MainApp app;

    public MessageRepository(Application app){
        this.app = (MainApp) app;
        messageDao = this.app.getDb().messageDAO();
    }

    public LiveData<List<Message>> getAllMessage(){
        if(messages == null){
            messages = messageDao.getAll();
        }
        return messages;
    }

    public LiveData<Message> get(long id){ return messageDao.get(id); }

    public void insert(Runnable completion, Message message){
        Thread t = new Thread(() -> {
            messageDao.insert(message);
        });
        t.start();
    }

    public void delete(Message... messages){ messageDao.delete(messages); }

}
