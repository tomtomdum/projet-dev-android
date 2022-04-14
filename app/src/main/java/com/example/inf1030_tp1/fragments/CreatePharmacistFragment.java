package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.PrimaryKey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Pharmacist;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.databinding.FragmentCreatePharmacistBinding;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.UUID;

public class CreatePharmacistFragment extends Fragment {

    private EditText firstName;
    private EditText lastName;
    private Spinner pharmacyName;
    private Button nextButton;
    private FragmentCreatePharmacistBinding fragmentCreatePharmacistBinding;

//    @NonNull
//    @PrimaryKey
//    private String id = UUID.randomUUID().toString();
//    private String password;
//    private String pharmacyId;
//    private String firstName;
//    private String lastName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_pharmacist, container, false);
        fragmentCreatePharmacistBinding = FragmentCreatePharmacistBinding.bind(view);
        firstName = fragmentCreatePharmacistBinding.pharmacistFirstName;
        lastName = fragmentCreatePharmacistBinding.pharmacistLastName;
        pharmacyName = fragmentCreatePharmacistBinding.pharmacySpinner;
        nextButton = fragmentCreatePharmacistBinding.nextButton;
        initSpinner();

        nextButton.setOnClickListener(this::CreatePharmacist);

        // Inflate the layout for this fragment
        return view;
    }

    private void initSpinner() {
        Spinner spinner = fragmentCreatePharmacistBinding.pharmacySpinner;
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.pharmacies, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void CreatePharmacist(View view) {
        if(!Utils.checkFields(getResources(), getActivity(), firstName, lastName)){
            if(checkPharma(pharmacyName)){

            }

            Pharmacist pharmacist = new Pharmacist(firstName.getText().toString(), lastName.getText().toString());


            // Create a bundle to pass the client object to the second fragment.
            Bundle bundle = new Bundle();
            bundle.putSerializable("pharmacist", pharmacist);

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

    private boolean checkPharma(Spinner pharmacy) {
        return false;
    }
}