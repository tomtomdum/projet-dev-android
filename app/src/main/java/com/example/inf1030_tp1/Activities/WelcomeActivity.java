package com.example.inf1030_tp1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityWelcomeBinding;

import com.example.inf1030_tp1.fragments.utils.Utils;

import com.example.inf1030_tp1.fragments.welcome.WelcomeFragment;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        setContentView(binding.getRoot());

//        String userType = getSharedPreferences(Utils.SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(Utils.SHARED_PREF_USER_TYPE_NAME,null);
//        if(userType != null){
//            Log.i("info", "the usertype is: "+ userType);
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }
//
//        getSupportFragmentManager().beginTransaction().
//                replace(R.id.fragment_container, new WelcomeFragment()).commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}