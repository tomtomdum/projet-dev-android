package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;


import com.example.inf1030_tp1.Data.DAO.UserDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UserRepository {

    private UserDAO userDao;
    private LiveData<List<User>> users;
    private MainApp app;

    public UserRepository(Application app){
        this.app = (MainApp) app;
        userDao = this.app.getDb().userDAO();
    }

    public LiveData<List<User>> getUsers(){
        if(users == null){
            Thread t = new Thread(() -> users = userDao.getAll());
            t.start();
        }
        return users;
    }

    public LiveData<User> get(String id){
        return userDao.get(id);
    }

    public void insert(Runnable completion, User user) {
        Thread t = new Thread(() -> {
            userDao.insert(user);
            completion.run();
        });
        t.start();
    }

    public void delete(Runnable completion, User user){
        Thread t =  new Thread(() -> {
            userDao.delete(user);
            completion.run();
        });
        t.start();
    }
}
