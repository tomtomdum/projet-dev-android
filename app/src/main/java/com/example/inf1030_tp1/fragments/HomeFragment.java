package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.inf1030_tp1.Adapters.OrderListAdapter;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.welcome.TypeUserFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OrderListAdapter orderListAdapter;
    private SearchView searchView;
    private List<Order> orderList;
    private View mView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
         mView = inflater.inflate(R.layout.fragment_home, container, false);

        setUpSearchView();


        //function in order to open a new fragment
        openAddOrderFragement(mView);
        initRecyclerView(mView);
        loadUserList();
        return mView;
    }

    private void setUpSearchView(){
        searchView = mView.findViewById(R.id.search_view);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String enteredText) {
                orderListAdapter.getFilter().filter(enteredText);
                return false;
            }
        });
    }
//    private void setUpSearchView1(){
//        searchView = mView.findViewById(R.id.search_view);
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
//        List<Order> filteredList = new ArrayList<>();
//        for(Order order: orderList){
//            if(order.getOrderName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(order);
//            }
//        }
//        if(filteredList.isEmpty()){
//            Toast.makeText(getActivity(),"No data found", Toast.LENGTH_LONG).show();
//        }else{
//            orderListAdapter.setFilteredList(filteredList);
//        }
//    }

    private void openAddOrderFragement(View v){
        v.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                AddOrderFragment addOrderFragment = new AddOrderFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_main,addOrderFragment).commit();
            }
        });
    }
    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_order_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        orderListAdapter = new OrderListAdapter(getActivity());
        recyclerView.setAdapter(orderListAdapter);
    }


    private void loadUserList(){
       // AppDataBase db = AppDataBase.getDbInstance(this.getApplicationContext());
        orderList = new ArrayList<>();
        Order order1 = new Order("Order_09/02/2022");
        Order order2 = new Order("Order_10/02/2022");

        orderList.add(order1);
        orderList.add(order2);

        orderListAdapter.setOrderList(orderList);
    }
}