package com.example.inf1030_tp1.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.List;

public class OrderListCartAdapterPharma extends RecyclerView.Adapter<OrderListCartAdapterPharma.ViewHolder>{
    private Context context;
    private List<Drug> drugList;
    private Order order;

    public OrderListCartAdapterPharma(Context context, List<Drug> drugList, Order order) {
        this.context = context;
        this.drugList = drugList;
        this.order = order;
        //initializeMap();
    }



    @NonNull
    @Override
    public OrderListCartAdapterPharma.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_cart_item_pharma,parent,false);
        return new OrderListCartAdapterPharma.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListCartAdapterPharma.ViewHolder holder, int position) {
        Drug drug = this.drugList.get(position);
        int qty = order.getDrugQuantity(drug);
        holder.drugName.setText(drug.getDci());
        holder.txtQuantity.setText(Integer.toString(qty));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(qty, drug);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drugList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView drugName;
        TextView description;
        TextView txtQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drugName = (TextView) itemView.findViewById(R.id.drug_name_pharma);
           description = (TextView)itemView.findViewById(R.id.description);
            txtQuantity = itemView.findViewById(R.id.qty_pharma);
        }
    }

    // obligé sinon cela plante dans le onbindViewHolder car la quantité est null
    public void initializeMap(){
        for (Drug drug: drugList) {
            order.setDrugQuantity(drug, 0);
        }
    }

    //Function to display the custom dialog.
    void showCustomDialog(int qty, Drug drug) {
        final Dialog dialog = new Dialog(context);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.custom_dialog);

        //Initializing the views of the dialog.

        final EditText ageEt = dialog.findViewById(R.id.age_et);
        ageEt.setText(Integer.toString(qty));

        Button submitButton = dialog.findViewById(R.id.submit_button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String qty = ageEt.getText().toString();

                order.setDrugQuantity(drug, Integer.parseInt(qty));
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
