package com.example.inf1030_tp1.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.HomeFragment;
import com.example.inf1030_tp1.fragments.pharmacist.HomeFragmentPharma;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivityPharma extends AppCompatActivity {

  private BottomNavigationView bindingMainActivityPharma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // bindingMainActivityPharma = DataBindingUtil.setContentView(this,R.layout.activity_main_pharma);
        setContentView(R.layout.activity_main_pharma);
        bindingMainActivityPharma = findViewById(R.id.bottomNavigationPharma);
        Fragment currentFragment = new HomeFragmentPharma();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_pharma, currentFragment)
                .commit();
                navigationMenu();
    }

    private void navigationMenu() {
        bindingMainActivityPharma.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.home_pharma:
                        selectedFragment = new HomeFragmentPharma();
                        break;
                    default:
                        selectedFragment = new HomeFragmentPharma();

                }
                // It will help to replace the
                // one fragment to other.
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_pharma, selectedFragment).addToBackStack(selectedFragment.getTag())
                        .commit();
                return true;
            }
        });
    }
}