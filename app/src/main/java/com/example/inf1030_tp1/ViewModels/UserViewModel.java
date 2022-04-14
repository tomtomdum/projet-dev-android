package com.example.inf1030_tp1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inf1030_tp1.Data.Repo.UserRepository;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Message;
import com.example.inf1030_tp1.Models.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepo;
    private LiveData<List<User>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepository(application);
    }

    public LiveData<List<User>> liveAll(){
        if(users == null) {
            users = userRepo.getUsers();
        }
        return users;
    }

    public void save(User user, Runnable completion){
        userRepo.insert(completion, user);
    }
}
