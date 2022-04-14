package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inf1030_tp1.Adapters.MessageAdapter;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Message;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.MessageViewModel;
import com.example.inf1030_tp1.databinding.FragmentMessageListBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageListFragment extends Fragment {
    private String conversationId;
    private RecyclerView recyclerView;
    private FragmentMessageListBinding mFragmentMessageListBinding;
    private MessageAdapter messageAdapter;
    private MessageViewModel messageViewModel;
    private ArrayList<Message> message;
    private Client client;

    public void setConversationId(String conversationId){
        this.conversationId = conversationId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);
        mFragmentMessageListBinding = FragmentMessageListBinding.bind(view);
        recyclerView = mFragmentMessageListBinding.messageList;
        messageAdapter = new MessageAdapter(getActivity(), new ArrayList<>(), "1");
//        recyclerView.setAdapter(messageAdapter);

        messageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        messageViewModel.liveAll().observe(getViewLifecycleOwner(), messages -> {
            List<Message> messageList = messages.stream().filter(message1 -> message1.getConversationId().equals(conversationId)).collect(Collectors.toList());
            messageAdapter.updateList((ArrayList<Message>)messageList);
            recyclerView.setAdapter(messageAdapter);
        });

        return view;
    }
}