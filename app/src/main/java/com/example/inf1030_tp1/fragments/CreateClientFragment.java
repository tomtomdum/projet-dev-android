package com.example.inf1030_tp1.fragments;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.FragmentCreateClientBinding;
import com.example.inf1030_tp1.fragments.utils.Utils;

public class CreateClientFragment extends Fragment {
    private FragmentCreateClientBinding fragmentCreateClientBinding;
    private EditText firstName;
    private EditText lastName;
    private EditText address;
    private EditText telephoneNumber;
    private Button signUpButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_client, container, false);
        fragmentCreateClientBinding = FragmentCreateClientBinding.bind(view);
        firstName = fragmentCreateClientBinding.clientFirstName;
        lastName = fragmentCreateClientBinding.clientLastName;
        address = fragmentCreateClientBinding.clientAddress;
        telephoneNumber = fragmentCreateClientBinding.clientTelephoneNumber;
        signUpButton = fragmentCreateClientBinding.signup;

        signUpButton.setOnClickListener(this::CreateClient);

        // Inflate the layout for this fragment
        return view;
    }

    private void CreateClient(View view) {
        if(!Utils.checkFields(getResources(), getActivity(), firstName, lastName, address, telephoneNumber)){

            Client client = new Client(firstName.getText().toString(), lastName.getText().toString());
            client.setAddress(address.getText().toString());
            client.setPhoneNumber(telephoneNumber.getText().toString());

            // Create a bundle to pass the client object to the second fragment.
            Bundle bundle = new Bundle();
            bundle.putSerializable("client", client);

            // Pass the object here
            CreateUserFragment createUserFragment = new CreateUserFragment();
            createUserFragment.setArguments(bundle);

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, createUserFragment)
                    .commit();
        }
    }
}