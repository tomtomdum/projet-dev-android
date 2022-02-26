package com.example.inf1030_tp1.activities;

import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.inf1030_tp1.Adapters.DrugListAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.ActivityDrugListBinding;

import java.util.ArrayList;

public class DrugListActivity extends AppCompatActivity {

    ArrayList<Drug> drugList = new ArrayList<>();
    DrugListAdapter adapter;
    private ActivityDrugListBinding binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this,R.layout.activity_drug_list);
        setContentView(binder.getRoot());

        populateList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_drug_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DrugListAdapter(this, drugList);
        recyclerView.setAdapter(adapter);
    }

    private void populateList(){
        for (int i =0; i<4; i++){
            drugList.add(new Drug("pillule", "goute pas bon"));
        }
    }
}