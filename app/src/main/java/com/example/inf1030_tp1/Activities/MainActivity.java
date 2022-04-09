package com.example.inf1030_tp1.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityMainBinding;
import com.example.inf1030_tp1.fragments.AddOrderFragment;
import com.example.inf1030_tp1.fragments.CartFragment;
import com.example.inf1030_tp1.fragments.HomeFragment;
import com.example.inf1030_tp1.fragments.MapFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindingMainActivity;

    public static String FragmentName = null;
//    private ActivityResultLauncher<String> requestPermissionLauncher =
//            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
//                if (isGranted) {
//                    // Permission is granted. Continue the action or workflow in your
//                    // app.
//                } else {
//                    // Explain to the user that the feature is unavailable because the
//                    // features requires a permission that the user has denied. At the
//                    // same time, respect the user's decision. Don't link to system
//                    // settings in an effort to convince the user to change their
//                    // decision.
//                    Toast.makeText(this,"Permission needed to display the map",Toast.LENGTH_SHORT).show();
//                }
//            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMainActivity = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(bindingMainActivity.getRoot());


//        Intent intent = getIntent();
//        String fragmentName = intent.getStringExtra("FRAGMENT_NAME");

        Fragment currentFragment = new HomeFragment();

        /*Test the fragmentName variable in order to know witch frsgment launch
            this variable is update in LoginFragment and SignUpFRagment
         */
        if(FragmentName == "CARTFRAGMENT"){
            currentFragment = new CartFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_main, currentFragment)
                .commit();
        this.configureToolbar();
        navigationMenu();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_cart:
      //CartFragment cartFragment = new CartFragment(HomeFragment.orders.get(HomeFragment.orders.size()-1));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_main,new CartFragment()).commit();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //2 - Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    private void navigationMenu(){
        bindingMainActivity.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.map:
                        selectedFragment = new MapFragment();
                        break;
                    default:
                         selectedFragment = new HomeFragment();

                }
                // It will help to replace the
                // one fragment to other.
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_main, selectedFragment).addToBackStack(selectedFragment.getTag())
                        .commit();
                return true;
            }
        });
    }
}