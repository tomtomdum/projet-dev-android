package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inf1030_tp1.Adapters.ConversationAdapter;
import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.Models.Message;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.ViewModels.ClientViewModel;
import com.example.inf1030_tp1.ViewModels.ConversationViewModel;
import com.example.inf1030_tp1.ViewModels.MessageViewModel;
import com.example.inf1030_tp1.databinding.FragmentConversationListBinding;

import java.util.ArrayList;

public class ConversationListFragment extends Fragment {
    private FragmentConversationListBinding fragmentConversationListBinding;
    private ConversationAdapter conversationAdapter;
    private ConversationViewModel conversationViewModel;
    private RecyclerView mRecyclerView;
    private ArrayList<Conversation> mConversations;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mRecyclerView = view.findViewById(R.id.recycler_view_conversation_list);
//        mConversations = new ArrayList<>();
//        conversationAdapter = new ConversationAdapter(getActivity(), mConversations, conversationId -> {
//            MessageListFragment messageListFragment = new MessageListFragment();
//            messageListFragment.setConversationId(conversationId);
//            getActivity().getSupportFragmentManager()
//                    .beginTransaction()
//                    .addToBackStack(String.valueOf(R.layout.fragment_conversation_list)) // ?? v??rifier
//                    .replace(R.id.fragment_container_main, messageListFragment)
//                    .commit();
//        });
//        mRecyclerView.setAdapter(conversationAdapter);

//
//        Client client = new Client("Philippe", "Baillargeon");
//        ClientViewModel clientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
//        clientViewModel.save(client, () -> {});

//        Conversation conversation = new Conversation();
//        ConversationViewModel conversationViewModel = new ViewModelProvider(this).get(ConversationViewModel.class);
//        conversationViewModel.save(conversation, () -> {
//            Log.i("info", "conversation cr????e");
//        });
//
//        Message message = new Message("Ceci est un message de r??ponse.", "2", conversation.getId());
//        MessageViewModel messageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
//        messageViewModel.save(message, () -> Log.i("info", "message successfully sent"));


//        conversationViewModel = new ViewModelProvider(this).get(ConversationViewModel.class);
//        conversationViewModel.liveAll().observe(getActivity(), conversations -> {
//            mConversations.addAll(conversations);
//            conversationAdapter.setConversations(mConversations);
////            mRecyclerView.setAdapter(conversationAdapter);
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_conversation_list, container, false);
        fragmentConversationListBinding = FragmentConversationListBinding.bind(view);
        mRecyclerView = fragmentConversationListBinding.recyclerViewConversationList;
        mConversations = new ArrayList<>();
        conversationAdapter = new ConversationAdapter(getActivity(), mConversations, conversationId -> {
            MessageListFragment messageListFragment = new MessageListFragment();
            messageListFragment.setConversationId(conversationId);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(String.valueOf(R.layout.fragment_conversation_list)) // ?? v??rifier
                    .replace(R.id.fragment_container_main, messageListFragment)
                    .commit();
        });
        mRecyclerView.setAdapter(conversationAdapter);
        conversationViewModel = new ViewModelProvider(this).get(ConversationViewModel.class);
        conversationViewModel.liveAll().observe(getViewLifecycleOwner(), conversations -> {
            ArrayList<Conversation> conversations1 = new ArrayList<>(conversations);
            conversationAdapter.updateList(conversations1);
//            mConversations.addAll(conversations);
//            conversationAdapter.setConversations(mConversations);
            mRecyclerView.setAdapter(conversationAdapter);
        });


        return view;
    }
}