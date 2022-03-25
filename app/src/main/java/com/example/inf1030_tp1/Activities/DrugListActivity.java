package com.example.inf1030_tp1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Adapters.DrugAdapter;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.DrugViewModel;

import java.util.ArrayList;

public class DrugListActivity extends AppCompatActivity {
    //TODO: va falloir utiliser les elements quont get de la base de donnees
    private ArrayList<Drug> drugList = new ArrayList<>();
    private ArrayList<Drug> drugListTest = new ArrayList<>();
    private DrugAdapter adapter;
//    private ActivityDrugListBinding binder;
    private Button addDrugTestButton;
    private DrugViewModel viewModel;
    private MainApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binder = DataBindingUtil.setContentView(this,R.layout.activity_drug_list);
        app = (MainApp) getApplicationContext();

////        RecyclerView recyclerView = findViewById(binder.recyclerViewDrugList.getId());
////        RecyclerView recyclerView = binder.getRoot().findViewById(binder.getRoot())
//
//        drugListTest = new ArrayList<>();
//        populateList();
//
//        viewModel = new ViewModelProvider(this).get(DrugViewModel.class);
//        viewModel.liveAll().observe(this, drugs -> {
//            adapter = new DrugAdapter(this, (ArrayList<Drug>) drugs, drug -> {
//                //Todo implementer une action faisant la selection
//            });
//            recyclerView.setAdapter(adapter);
//        });

//        addDrugTestButton = binder.testButton;
        addDrugTestButton.setOnClickListener(view -> {
            for (Drug drug : drugListTest) {
                viewModel.save(drug, ()->{
                    Log.i("info", "the drug "+ drug.toString());
                });
            }
        });
    }

    private void populateList(){
        for (int i =0; i<4; i++){
            Drug drug = new Drug();
            drug.setDescription("graasdf");
            drug.setName("pillule "+i);
            drugListTest.add(drug);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem drugSearchBar = menu.findItem(R.id.search);
        SearchView SV = (SearchView) drugSearchBar.getActionView();

        SV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String enteredText) {
                adapter.getFilter().filter(enteredText);
                return false;
            }
        });
        return true;
    }
}