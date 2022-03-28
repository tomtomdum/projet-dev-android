package com.example.inf1030_tp1.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inf1030_tp1.Adapters.OrderListCartAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.Activities.UserManagerActivity;
import com.example.inf1030_tp1.fragments.utils.ChooseOrder;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OrderListCartAdapter mOrderListCartAdapter;
    private List<Drug> drugCartList;
    private Button btnDelete;
    private Order order;
    //private SharedPreferences mPreferences ;
    public CartFragment(Order order) {
        this.order = order;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2, Order order) {
        CartFragment fragment = new CartFragment(order);
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
        View mView = inflater.inflate(R.layout.fragment_cart, container, false);
//        // Inflate the layout for this fragment
//       TextView tv =  mView.findViewById(R.id.tvText);
//       int sizeList = ChooseOrder.drugList.size();
//       tv.setText(Integer.toString(sizeList));
        //Log.i("List Drug", "SIZE : " + ChooseOrder.drugList.size());

        //getActivity().getSharedPreferences(ChooseOrder.SHARED_PREF_USER_INFO, Context.MODE_PRIVATE);

        initRecyclerView(mView);

        searchButton(mView.findViewById(R.id.btn_search));
        searchButton(mView.findViewById(R.id.btn_search_1));
        searchButton(mView.findViewById(R.id.btn_search_2));

        return mView;
    }

    private void searchButton(View mView){
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(),"OKKKK",Toast.LENGTH_SHORT).show();
               String userName = getActivity().getSharedPreferences(ChooseOrder.SHARED_PREF_USER_INFO,Context.MODE_PRIVATE).getString(ChooseOrder.SHARED_PREF_USER_INFO_NAME,null);
                if(userName == null){
//                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
//                    LoginFragment userFragment = new LoginFragment();
//                    activity.getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container_main,userFragment).commit();
                    Intent intent = new Intent(getActivity(), UserManagerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_order_list_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        mOrderListCartAdapter = new OrderListCartAdapter(getActivity(), order.getDrugs(), order);
        recyclerView.setAdapter(mOrderListCartAdapter);
    }
}