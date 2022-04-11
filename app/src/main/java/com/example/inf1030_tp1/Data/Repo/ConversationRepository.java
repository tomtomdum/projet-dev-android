package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.DAO.ConversationDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

public class ConversationRepository {

    private ConversationDAO mConversationDAO;
    private LiveData<List<Conversation>> conversations;
    private MainApp app;

    public ConversationRepository(Application app){
        this.app = (MainApp) app;
        mConversationDAO = this.app.getDb().ConversationDAO();
    }

    public LiveData<List<Conversation>> getAllConversations(){
        if(conversations == null){
            conversations = mConversationDAO.getAll();
        }
        return conversations;
    }

    public LiveData<Conversation> get(String id){ return mConversationDAO.get(id); }

    public void insert(Runnable completion, Conversation conversation){
        Thread t = new Thread(() -> {
            mConversationDAO.insert(conversation);
        });
        t.start();
    }

    public void delete(Conversation... conversations){ mConversationDAO.delete(conversations); }
}
