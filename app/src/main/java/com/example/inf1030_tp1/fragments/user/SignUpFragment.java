package com.example.inf1030_tp1.fragments.user;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button mBtn_register;
    private EditText mEtName, mEtMail, mEtPass, mEtPassConfirm;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */

    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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

        View mView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        mView.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                LoginFragment loginFragment = new LoginFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_user,loginFragment).commit();
            }
        });
        //
        mBtn_register = mView.findViewById(R.id.btn_signup);
        mEtName = mView.findViewById(R.id.name);
        mEtPass = mView.findViewById(R.id.etPass);
        mEtPassConfirm = mView.findViewById(R.id.etConfirmPass);
        mEtMail = mView.findViewById(R.id.etEmail);

        signUp();
        return mView;
    }

    private void signUp() {
        mBtn_register.setOnClickListener(view -> {


            if(mEtName.getText().toString().isEmpty() || mEtMail.getText().toString().isEmpty() || mEtPass.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Please complete all fields !", Toast.LENGTH_LONG).show();
            }else if(!mEtPass.getText().toString().equals(mEtPassConfirm.getText().toString())){
                Toast.makeText(getContext(), "Both passwords must be the same !"+ mEtPass.getText().toString() + " - " + mEtPassConfirm.getText().toString(), Toast.LENGTH_LONG).show();
            }else {
                //Call the view model who manage the sign up action

                //If the user is connected
                getActivity().getSharedPreferences(Utils.SHARED_PREF_USER_INFO, Context.MODE_PRIVATE)
                        .edit()
                        .putString(Utils.SHARED_PREF_USER_INFO_NAME, mEtMail.toString())
                        .apply();

                //Update the FRAGMENTNAME static variable who is in MainActivity\
                MainActivity.FragmentName = "CARTFRAGMENT";
                Intent intent = new Intent(getActivity(), MainActivity.class);
                //intent.putExtra("FRAGMENT_NAME", "CARTFRAGMENT");
                startActivity(intent);
            }
        });


    }
}