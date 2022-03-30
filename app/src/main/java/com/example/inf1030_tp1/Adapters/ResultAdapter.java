package com.example.inf1030_tp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{
    private Context context;
    private List<Pharmacy> pharmacyList;

    public ResultAdapter(Context context, List<Pharmacy> pharmacyList) {
        this.context = context;
        this.pharmacyList = pharmacyList;
//        initializeMap();
    }

    @NonNull
    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_result,parent,false);
        return new ResultAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ViewHolder holder, int position) {
        Pharmacy pharmacy = this.pharmacyList.get(position);
        holder.pharmacyName.setText(pharmacy.getName());
       // holder.kilometer.setText(Integer.toString(pharmacy.get));
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pharmacyName;
        TextView kilometer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pharmacyName = (TextView) itemView.findViewById(R.id.pharmacy_name);
            kilometer = (TextView) itemView.findViewById(R.id.kilometer);
        }
    }

    // obligé sinon cela plante dans le onbindViewHolder car la quantité est null
    public void setPharmacyList(Pharmacy pharmacy){
       this.pharmacyList.add(pharmacy);
       // this.pharmacyList = pharmacy;
        notifyDataSetChanged();
    }
}
