package com.example.inf1030_tp1.fragments;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.inf1030_tp1.Adapters.DrugAdapter;
import com.example.inf1030_tp1.Adapters.OrderListAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.DrugViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private DrugViewModel viewModel;
    private DrugAdapter mDrugListAdapter;
    private ArrayList<Drug> drugList = new ArrayList<>();
    private SearchView searchView;
    private List<Order> orderList;
    private View mView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddOrderFragment newInstance(String param1, String param2) {
        AddOrderFragment fragment = new AddOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         mView =  inflater.inflate(R.layout.fragment_add_order, container, false);
        setUpSearchView();
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_drug_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModel = new ViewModelProvider(this).get(DrugViewModel.class);
        viewModel.liveAll().observe(getActivity(), drugs -> {
            mDrugListAdapter = new DrugAdapter(getActivity(), (ArrayList<Drug>) drugs, drug -> {
                //Todo implementer une action faisant la selection
            });
            Log.i("info", "testfffff: "+ mDrugListAdapter.getItemCount());
            recyclerView.setAdapter(mDrugListAdapter);
        });
    }

    private void setUpSearchView(){
        searchView =  mView.findViewById(R.id.search_view);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String enteredText) {
                mDrugListAdapter.getFilter().filter(enteredText);
                return false;
            }
        });
    }
}