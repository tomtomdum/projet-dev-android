package com.example.inf1030_tp1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityLoginPageBinding;

public class LoginPageActivity extends AppCompatActivity {

    private Button button;
    private ActivityLoginPageBinding binder;
    private MainApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_login_page);
        button = binder.logButton;
        button.setOnClickListener(this::openRecyclerView);
    }

    public void openRecyclerView(View view){
        Intent intent = new Intent(this,DrugListActivity.class);
        startActivity(intent);
    }
}