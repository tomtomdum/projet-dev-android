package com.example.inf1030_tp1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityMainBinding;
import com.example.inf1030_tp1.fragments.HomeFragment;

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

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_search:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();
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

    // ----

    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }
}