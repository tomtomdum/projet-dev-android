package com.example.inf1030_tp1.fragments.pharmacist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inf1030_tp1.Adapters.OrderListAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentPharma#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentPharma extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OrderListAdapter orderListAdapter;
    private List<Order> orderList;
    private View mView;
    public HomeFragmentPharma() {
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
    public static HomeFragmentPharma newInstance(String param1, String param2) {
        HomeFragmentPharma fragment = new HomeFragmentPharma();
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
        mView = inflater.inflate(R.layout.fragment_home_pharma, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_order_list_pharma);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        orderListAdapter = new OrderListAdapter(getActivity());

        recyclerView.setAdapter(orderListAdapter);
        loadUserList();
    }

    private void loadUserList(){
        // AppDataBase db = AppDataBase.getDbInstance(this.getApplicationContext());
        orderList = new ArrayList<>();
     //   orderList = Utils.sOrderList;
        Order order1 = new Order("Order_09/02/2022");
        List<Drug> drugList = new ArrayList<>();

        Drug drug1 = new Drug();
        drug1.setDci("Drug1");

        Drug drug2 = new Drug();
        drug2.setDci("Drug2");

        drugList.add(drug1);
        drugList.add(drug2);
        order1.setDrugs((ArrayList<Drug>) drugList);

        order1.setDrugQuantity(drug1,3);
        order1.setDrugQuantity(drug2, 5);

        Order order2 = new Order("Order_10/02/2022");

        orderList.add(order1);
        orderList.add(order2);


        orderListAdapter.setOrderList(orderList);
    }
}