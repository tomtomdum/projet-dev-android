package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;
import java.util.List;

public class OrderListCartAdapter extends RecyclerView.Adapter<OrderListCartAdapter.ViewHolder>{
    private Context context;
    private List<Drug> drugList;

    public OrderListCartAdapter(Context context, List<Drug> drugList) {
        this.context = context;
        this.drugList = drugList;
    }

    @NonNull
    @Override
    public OrderListCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_cart_item,parent,false);
        return new OrderListCartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drug drug = this.drugList.get(position);
        holder.drugName.setText(drug.getName());
    }

    @Override
    public int getItemCount() {
        return drugList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView drugName;
        //TextView drugName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drugName = (TextView) itemView.findViewById(R.id.drug_name);

        }
    }
}
