package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.inf1030_tp1.Models.Conversation;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.MessageListFragment;
import com.example.inf1030_tp1.fragments.utils.OnClickConversation;

import java.util.ArrayList;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {
    private ArrayList<Conversation> conversations;
    private final LayoutInflater mInflater;
    private final OnClickConversation onClickItem;

    public ConversationAdapter(Context context, ArrayList<Conversation> conversations, OnClickConversation onClickItem){
        mInflater = LayoutInflater.from(context);
        this.conversations = conversations;
//        Log.i("info", "CONVERSATIONS: "+ conversations);
        this.onClickItem = onClickItem;
    }

    public void setConversations(ArrayList<Conversation> conversations){
        this.conversations = conversations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.proto_conversation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resources res = mInflater.getContext().getResources();
        holder.mTextView.setText(res.getString(R.string.conversation_title, String.valueOf(position+1)));
        holder.mTextView.setOnClickListener(view -> {
            Log.i("info", "you clicked on the convo: "+ position);
            String conversationId = conversations.size() > 0 ? conversations.get(position).getId() : "";
            onClickItem.onClickConversation(conversationId);
        });
    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.conversation_title);
        }


    }
}
