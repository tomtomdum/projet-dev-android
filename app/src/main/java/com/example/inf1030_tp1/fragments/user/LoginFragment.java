package com.example.inf1030_tp1.fragments.user;


import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inf1030_tp1.Activities.MainActivity;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.CartFragment;
import com.example.inf1030_tp1.fragments.utils.Utils;

import com.example.inf1030_tp1.fragments.welcome.TypeUserFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private  Button btnLogin;
    private EditText mEtEmail;
    private EditText mPass;

    // TODO: Rename and change types of parameters

    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
       View mView = inflater.inflate(R.layout.fragment_login, container, false);
       mView.findViewById(R.id.signup).setOnClickListener(view -> {
               AppCompatActivity activity = (AppCompatActivity)view.getContext();
               SignUpFragment signUpFragment = new SignUpFragment();
               activity.getSupportFragmentManager().beginTransaction()
                       .replace(R.id.fragment_container_user,signUpFragment).commit();
           });

        btnLogin = mView.findViewById(R.id.btn_login);
        mEtEmail = mView.findViewById(R.id.etEmail);
        mPass = mView.findViewById(R.id.etEmail);

           login();
        return mView;
    }


    private void login() {
        btnLogin.setOnClickListener(view -> {

            if(mEtEmail.getText().toString().isEmpty() || mPass.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Please complete all fields !", Toast.LENGTH_LONG).show();
            }else {

                //Call the viewMOdel who manage the login action

                //If the user is connected
                getActivity().getSharedPreferences(Utils.SHARED_PREF_USER_INFO, Context.MODE_PRIVATE)
                        .edit()
                        .putString(Utils.SHARED_PREF_USER_INFO_NAME, mEtEmail.toString())
                        .apply();

//            AppCompatActivity activity = (AppCompatActivity)view.getContext();
//
//            activity.getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container_main,new CartFragment()).commit();

                Intent intent = new Intent(getActivity(), MainActivity.class);

                //Update the FRAGMENTNAME static variable who is in MainActivity
                MainActivity.FragmentName = "CARTFRAGMENT";

                //intent.putExtra("FRAGMENT_NAME", "CARTFRAGMENT");
                startActivity(intent);
            }
        });
    }

}