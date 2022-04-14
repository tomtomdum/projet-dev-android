package com.example.inf1030_tp1.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.ConversationRepository;
import com.example.inf1030_tp1.Data.Repo.MessageRepository;
import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.Models.Message;

import java.util.List;

public class ConversationViewModel extends AndroidViewModel{

    private ConversationRepository repo;
    private LiveData<List<Conversation>> conversations;

    public ConversationViewModel(Application app){
        super(app);
        repo = new ConversationRepository(app);
    }

    public LiveData<List<Conversation>> liveAll(){
        if(conversations == null) {
            conversations = repo.getAllConversations();
        }
        return  conversations;
    }

    public void save(Conversation conversation, Runnable completion){
        repo.insert(completion, conversation);
    }
}
