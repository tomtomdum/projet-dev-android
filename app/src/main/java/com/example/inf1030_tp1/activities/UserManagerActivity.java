package com.example.inf1030_tp1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.user.LoginFragment;

public class UserManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container_user, new LoginFragment()).commit();
    }
}