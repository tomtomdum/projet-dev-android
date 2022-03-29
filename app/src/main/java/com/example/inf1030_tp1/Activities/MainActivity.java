package com.example.inf1030_tp1.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

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
import com.google.android.material.navigation.NavigationBarView;

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
        this.configureToolbar();
        navigationMenu();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_cart:
                // User chose the "Settings" item, show the app settings UI...
                /*
                on va chercher la liste static qui contient tous les orders en avoir qu'une seule et
                unique dans tout l'application. Dance ce cas si on utilise la derniere créé à fin de
                test, mais avec la liste facilement acessible, nous pourront implémenter plus tard un
                moyen de selectionner quelle Order que nous voulons accéder au panier
                 */
                CartFragment cartFragment = new CartFragment(HomeFragment.orders.get(HomeFragment.orders.size()-1));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_main,cartFragment).commit();
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