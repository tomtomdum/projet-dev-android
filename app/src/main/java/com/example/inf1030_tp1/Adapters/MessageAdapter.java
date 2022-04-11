package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Client;
import com.example.inf1030_tp1.Models.Message;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Message> messages;
    private String clientId;
    private final int MESSAGE_DROITE = 0;
    private final int MESSAGE_GAUCHE = 1;

    public MessageAdapter(Context context, ArrayList<Message> listMessage, String clientId){
        this.messages = listMessage;
        this.inflater = LayoutInflater.from(context);
        this.clientId = clientId;
    }

    public void updateList(ArrayList<Message> messages){
        this.messages.clear();
        this.messages.addAll(messages);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = viewType == MESSAGE_DROITE ? inflater.inflate(R.layout.proto_message_droit, parent, false)
                : inflater.inflate(R.layout.proto_message_gauche, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.messagedroite.setText(messages.get(position).getContent());
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if(message.getSenderId().equals(clientId)){
            return MESSAGE_GAUCHE;
        } else return MESSAGE_DROITE;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView messagedroite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            messagedroite = itemView.findViewById(R.id.message);
        }
    }
}
