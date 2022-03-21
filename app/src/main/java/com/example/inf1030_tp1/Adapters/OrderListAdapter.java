package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private Context context;
    private List<Order> orderList;

    public OrderListAdapter(Context context) {
        this.context = context;
    }

    public void setOrderList(List<Order> orderList){

        this.orderList = orderList;
    }

    public void setFilteredList(List<Order> filteredList){
            this.orderList = filteredList;
            notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Order order = this.orderList.get(position);
        holder.orderName.setText(order.getOrderName());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

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
