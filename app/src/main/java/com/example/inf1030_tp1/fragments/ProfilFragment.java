package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inf1030_tp1.R;

public class ProfilFragment extends Fragment {
    private Button messagesButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        messagesButton = view.findViewById(R.id.chat_button);
        messagesButton.setOnClickListener(this::onClickMessages);
    }

    private void onClickMessages(View view) {
        Fragment fragment = new ConversationListFragment();
        String backStateName = getClass().getName();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_main, fragment)
                .addToBackStack(backStateName)
                .commit();
    }
}