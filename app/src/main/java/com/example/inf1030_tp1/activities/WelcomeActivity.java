package com.example.inf1030_tp1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Button;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.frgagments.welcome.WelcomeFragment;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, new WelcomeFragment()).commit();
    }

}