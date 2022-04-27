package com.example.inf1030_tp1.fragments.pharmacist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.inf1030_tp1.Adapters.OrderListCartAdapter;
import com.example.inf1030_tp1.Adapters.OrderListCartAdapterPharma;
import com.example.inf1030_tp1.Adapters.ResultAdapter;
import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragmentPharma#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragmentPharma extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ResultAdapter mResultAdapter;
    private List<Pharmacy> mPharmacyList;
    TextView txtOrderName;
    private OrderListCartAdapterPharma mOrderListCartAdapterPharma;
    private List<Drug> drugCartList;
    private Button btnDelete;
    private Order order;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragmentPharma() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragmentPharma.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragmentPharma newInstance(String param1, String param2) {
        OrderFragmentPharma fragment = new OrderFragmentPharma();
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

        //recover static order variable
        order = Utils.sOrder;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_order_pharma, container, false);
        txtOrderName = mView.findViewById(R.id.order_name_result_fragment_pharma);
        txtOrderName.setText(order.getmOrderName().toLowerCase().toString());

        TextView textView = getActivity().findViewById(R.id.page_title);
        textView.setText("ORDER");

        getActivity().findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // getActivity().finish();
                getActivity().onBackPressed();

            }
        });
        initRecyclerView(mView);
        return mView;
    }

    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_order_list_cart_pharma);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(order != null)
            mOrderListCartAdapterPharma = new OrderListCartAdapterPharma(getActivity(), order.getDrugs(), order);

        recyclerView.setAdapter(mOrderListCartAdapterPharma);
    }
}