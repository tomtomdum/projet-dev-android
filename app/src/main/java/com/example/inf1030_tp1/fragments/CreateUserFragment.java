package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inf1030_tp1.Data.Clients.RetrofitClient;
import com.example.inf1030_tp1.Data.Enum.Role;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Pharmacist;
import com.example.inf1030_tp1.Models.User;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.ClientViewModel;
import com.example.inf1030_tp1.ViewModels.ConversationViewModel;
import com.example.inf1030_tp1.ViewModels.PharmacistViewModel;
import com.example.inf1030_tp1.ViewModels.UserViewModel;
import com.example.inf1030_tp1.databinding.FragmentCreateUserBinding;
import com.example.inf1030_tp1.fragments.utils.Utils;

public class CreateUserFragment extends Fragment {

    private FragmentCreateUserBinding fragmentCreateUserBinding;
    private Client client;
    private Pharmacist pharmacist;
    private EditText username;
    private EditText password;
    private Button createButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        client = (Client) bundle.getSerializable("client");
        pharmacist = (Pharmacist) bundle.getSerializable("pharmacist");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);
        fragmentCreateUserBinding = FragmentCreateUserBinding.bind(view);
        username = fragmentCreateUserBinding.userUsername;
        password = fragmentCreateUserBinding.userPassword;
        createButton = fragmentCreateUserBinding.userCreate;

        createButton.setOnClickListener(this::CreateUser);


        // Inflate the layout for this fragment
        return view;
    }

    private void CreateUser(View view) {
        if(!Utils.checkFields(getResources(), getActivity(), username, password)){
            UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
            User user = null;
            if(client != null){
                // todo saver le client dans firebase
                user = new User(username.getText().toString(), password.getText().toString());
                user.setUserId(client.getId());
                user.setRole(Role.CLIENT);
                ClientViewModel clientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
                clientViewModel.save(client, () -> {});

            }else if(pharmacist != null){

                user = new User(username.getText().toString(), password.getText().toString());
                user.setUserId(pharmacist.getId());
                user.setRole(Role.PHARMACIST);
                PharmacistViewModel pharmacistViewModel = new ViewModelProvider(this).get(PharmacistViewModel.class);
                pharmacistViewModel.save(pharmacist, () -> {});
                // todo saver le pharmacien dans firebase
            }
            if(user != null){
                userViewModel.save(user, () -> {});
            }
        }
    }

}