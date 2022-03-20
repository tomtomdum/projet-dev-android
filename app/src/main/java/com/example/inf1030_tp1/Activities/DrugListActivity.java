package com.example.inf1030_tp1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Adapters.DrugListAdapter;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.DrugListViewModel;
import com.example.inf1030_tp1.databinding.ActivityDrugListBinding;

import java.util.ArrayList;

public class DrugListActivity extends AppCompatActivity {
    //TODO: va falloir utiliser les elements quont get de la base de donnees
    private ArrayList<Drug> drugList = new ArrayList<>();
    private ArrayList<Drug> drugListTest = new ArrayList<>();
    private DrugListAdapter adapter;
    private ActivityDrugListBinding binder;
    private Button addDrugTestButton;
    private DrugListViewModel viewModel;
    private MainApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this,R.layout.activity_drug_list);
        app = (MainApp) getApplicationContext();

        RecyclerView recyclerView = findViewById(binder.recyclerViewDrugList.getId());

        drugListTest = new ArrayList<>();
        populateList();

//        DrugListAdapter drugListAdapter = new DrugListAdapter(this, drugListTest, drug -> {});
//        recyclerView.setAdapter(drugListAdapter);

        viewModel = new ViewModelProvider(this).get(DrugListViewModel.class);
        viewModel.liveAll().observe(this, drugs -> {
            adapter = new DrugListAdapter(this, drugList, drug -> {
                Log.i("info", "This is a test "+drug);
                //Todo implementer une action faisant la selection
            });
            recyclerView.setAdapter(adapter);
        });

        addDrugTestButton = binder.testButton;
        addDrugTestButton.setOnClickListener(view -> {
            for (Drug drug : drugListTest) {
                viewModel.save(drug, ()->{

                });
            }
//            drugListTest.forEach(drug -> viewModel.save(drug, () -> {}));
        });
    }

    private void populateList(){
        for (int i =0; i<4; i++){
            drugListTest.add(new Drug("pillule" + i, "goute pas bon"));
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