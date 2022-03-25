package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> implements Filterable {
    private Context context;
    private List<Order> orderList;
    private List<Order> orderListCopy;

    public OrderListAdapter(Context context) {

        this.context = context;
        orderListCopy = new ArrayList<>();
    }

    public void setOrderList(List<Order> orderList){

        this.orderList = orderList;
        orderListCopy.addAll((List)orderList);
    }

    public void setFilteredList(List<Order> filteredList){
        this.orderList.clear();
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
        holder.orderName.setText(order.getmOrderName());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
/**
        * Recois le texte de la barre de recherche et filtre la liste, ensuite il affiche la nouvelle
     * liste
     */
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Order> orderListFiltered = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                orderListFiltered.addAll(orderListCopy);
            }
            else {
                String filterString = charSequence.toString().toLowerCase().trim();
                for( Order order: orderListCopy) {
                    if(order.getmOrderName().toLowerCase().contains(filterString)){
                        orderListFiltered.add(order);
                    }
                }
            }
            FilterResults resultsFromSearch = new FilterResults();
            resultsFromSearch.values = orderListFiltered;
            return resultsFromSearch;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            orderList.clear();
            orderList.addAll((List) filterResults.values);
            notifyDataSetChanged();// for lactualisation de la liste
        }
    };

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
