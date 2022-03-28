package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.utils.ChooseOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderListCartAdapter extends RecyclerView.Adapter<OrderListCartAdapter.ViewHolder>{
    private Context context;
    private List<Drug> drugList;
    private Order order;

    public OrderListCartAdapter(Context context, List<Drug> drugList, Order order) {
        this.context = context;
        this.drugList = drugList;
        this.order = order;
        initializeMap();
    }

    private void deleteItem(TextView btnDelete, int position){

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugList.remove(position);
                ChooseOrder.drugList = drugList;
                notifyDataSetChanged();
            }
        });
    }

    private void plusQty(TextView txtQty, Button btnPlus, int position){
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   int qty = Integer.parseInt((String) txtQty.getText());
                    qty++;
                    order.setDrugQuantity(drugList.get(position), qty);
                  notifyDataSetChanged();
                }
            });
    }
private void lessQty(TextView txtQty, Button btnLess, int position){
    btnLess.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int qty = Integer.parseInt((String) txtQty.getText());
            if(qty > 0) qty--;
            order.setDrugQuantity(drugList.get(position), qty);
            notifyDataSetChanged();
        }
    });
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
        holder.drugName.setText(drug.getDci());
        holder.txtQuantity.setText(Integer.toString(order.getDrugQuantity(drug)));
        deleteItem(holder.btnDelete, position);
        plusQty(holder.txtQuantity, holder.btnPlus, position);
        lessQty(holder.txtQuantity, holder.btnLess, position);
    }

    @Override
    public int getItemCount() {
        return drugList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView drugName;
        TextView btnDelete;
        Button btnPlus;
        Button btnLess;
        TextView txtQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drugName = (TextView) itemView.findViewById(R.id.drug_name);
            btnDelete = (TextView) itemView.findViewById(R.id.delete_item);
            btnPlus = itemView.findViewById(R.id.plus_btn);
            btnLess = itemView.findViewById(R.id.less_btn);
            txtQuantity = itemView.findViewById(R.id.qty);
        }
    }

    // obligé sinon cela plante dans le onbindViewHolder car la quantité est null
    public void initializeMap(){
        for (Drug drug: drugList) {
            order.setDrugQuantity(drug, 0);
        }
    }
}
