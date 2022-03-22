package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inf1030_tp1.Adapters.DrugListAdapter;
import com.example.inf1030_tp1.Adapters.OrderListCartAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.R;
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
    public CartFragment() {
        // Required empty public constructor
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
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        initRecyclerView(mView);

        return mView;
    }


    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_order_list_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        mOrderListCartAdapter = new OrderListCartAdapter(getActivity(),ChooseOrder.drugList);
        recyclerView.setAdapter(mOrderListCartAdapter);
    }
}