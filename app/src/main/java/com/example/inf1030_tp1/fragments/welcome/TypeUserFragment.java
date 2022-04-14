package com.example.inf1030_tp1.fragments.welcome;


import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.Activities.MainActivity;

import com.example.inf1030_tp1.fragments.CreateClientFragment;
import com.example.inf1030_tp1.fragments.CreatePharmacistFragment;
import com.example.inf1030_tp1.fragments.utils.Utils;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TypeUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TypeUserFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public TypeUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TypeUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TypeUserFragment newInstance(String param1, String param2) {
        TypeUserFragment fragment = new TypeUserFragment();
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
        View mView = inflater.inflate(R.layout.fragment_type_user, container, false);
        mView.findViewById(R.id.btn_client).setOnClickListener(view -> {
            SharedPreferences preferences = getActivity().getSharedPreferences(Utils.SHARED_PREF_USER_INFO, MODE_PRIVATE);
            preferences.edit()
            .putString(Utils.SHARED_PREF_USER_TYPE_NAME, "client")
            .apply();
            createUser();
        });
        mView.findViewById(R.id.btn_pharma).setOnClickListener(view -> {
            SharedPreferences preferences = getActivity().getSharedPreferences(Utils.SHARED_PREF_USER_INFO, MODE_PRIVATE);
            preferences.edit()
                    .putString(Utils.SHARED_PREF_USER_TYPE_NAME, "pharmacist")
                    .apply();
            createUser();
        });
        return mView;
    }

    public void createUser(){
       String userType = getActivity().getSharedPreferences(Utils.SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(Utils.SHARED_PREF_USER_TYPE_NAME,null);
       if(userType.equals("client")){
           getActivity().getSupportFragmentManager()
                   .beginTransaction()
                   .addToBackStack(null)
                   .replace(R.id.fragment_container, new CreateClientFragment())
                   .commit();
       }else if(userType.equals("pharmacist")){
           getActivity().getSupportFragmentManager()
                   .beginTransaction()
                   .addToBackStack(null)
                   .replace(R.id.fragment_container, new CreatePharmacistFragment())
                   .commit();
       }
    }
}