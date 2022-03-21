package com.example.inf1030_tp1.Adapters;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.R;

public class OrderListCartAdapter {
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderName;
        //TextView drugName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();
                }
            });

            orderName = (TextView) itemView.findViewById(R.id.order_name);
            //description = (TextView) itemView.findViewById(R.id.description);

        }
    }
}
