package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.inf1030_tp1.Adapters.DrugListAdapter;
import com.example.inf1030_tp1.Adapters.OrderListAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;

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

    private DrugListAdapter mDrugListAdapter;
    private ArrayList<Drug> drugList = new ArrayList<>();
    private SearchView searchView;
    private List<Order> orderList;
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
        View mView =  inflater.inflate(R.layout.fragment_add_order, container, false);
        setUpSearchView();
        populateList();
        initRecyclerView(mView);
        return mView;
    }

    private void setUpSearchView(){
        searchView = getActivity().findViewById(R.id.search_view);
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
//    private void setUpSearchView1(){
//        searchView = getActivity().findViewById(R.id.search_view);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                filterList(s);
//                return true;
//            }
//        });
//    }
//    private void filterList(String text) {
//        ArrayList<Drug> filteredList = new ArrayList<>();
//        for(Drug drug: drugList){
//            if(drug.getName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(drug);
//            }
//        }
//        if(filteredList.isEmpty()){
//            Toast.makeText(getActivity(),"No data found", Toast.LENGTH_LONG).show();
//        }else{
//            mDrugListAdapter.setFilteredList(filteredList);
//        }
//    }

    private void populateList(){
        for (int i =0; i<4; i++){
            drugList.add(new Drug("pillule" + i, "goute pas bon"));
        }
    }

    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_drug_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        mDrugListAdapter = new DrugListAdapter(getActivity(),drugList);
        recyclerView.setAdapter(mDrugListAdapter);
    }
}