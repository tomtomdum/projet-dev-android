package com.example.inf1030_tp1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityLoginPageBinding;

public class LoginPage extends AppCompatActivity {
    private ActivityLoginPageBinding binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_login_page);
        setContentView(binder.getRoot());
    }
}