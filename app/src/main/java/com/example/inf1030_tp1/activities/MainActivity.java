package com.example.inf1030_tp1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityMainBinding;
import com.example.inf1030_tp1.frgagments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bindingMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMainActivity = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(bindingMainActivity.getRoot());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_main, new HomeFragment())
                .commit();

    }
}