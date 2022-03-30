package com.example.inf1030_tp1.Adapters;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;
import com.example.inf1030_tp1.fragments.HomeFragment;
import com.example.inf1030_tp1.fragments.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DrugAdapter extends RecyclerView.Adapter<DrugAdapter.ViewHolder> implements Filterable {
    private ArrayList<Drug> drugList = new ArrayList<>();
    private ArrayList<Drug> drugListCopy; // copie de la liste originale, utilisee pour filtrer le resutlat de recherche
    private Consumer<Drug> consumer;
    private LayoutInflater inflater;

    private Order order = new Order("test");

    public DrugAdapter(Context context, ArrayList<Drug> list, Consumer<Drug> consumer){
        this.inflater = LayoutInflater.from(context);
        this.drugList = list;
        drugListCopy = new ArrayList<>(list);
        this.consumer = consumer;

        //HomeFragment.orders.add(order);
        /*I added a order object into a static order object who
        is in Utils class instead to add it into a list
         */
        Utils.sOrder = order;

    }



    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View view = inflater.inflate(R.layout.drug_list_prototype, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Quand on bind le viewholder, on va chercher les informations du medicament
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Drug drug = drugList.get(position);
        viewHolder.description.setText(drugList.get(position).getForm());
        viewHolder.drugName.setText(drugList.get(position).getDci());

        viewHolder.itemView.setOnClickListener(listener -> {
            consumer.accept(drugList.get(position));
            if(!order.itemIsInTheList(drug)){
                order.addDrug(drug);
            }
            Toast.makeText(listener.getContext(), "Drug Added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return drugList.size();
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
            List<Drug> drugListFiltered = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                drugListFiltered.addAll(drugListCopy);
            }
            else {
                String filterString = charSequence.toString().toLowerCase().trim();
                for( Drug drug: drugListCopy) {
                    if(drug.getDci().toLowerCase().contains(filterString)){
                        drugListFiltered.add(drug);
                    }
                }
            }
            FilterResults resultsFromSearch = new FilterResults();
            resultsFromSearch.values = drugListFiltered;
            return resultsFromSearch;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            drugList.clear();
            drugList.addAll((List) filterResults.values);
            notifyDataSetChanged();// for lactualisation de la liste
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        TextView drugName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            drugName = (TextView) itemView.findViewById(R.id.nom_item);
            description = (TextView) itemView.findViewById(R.id.description);

        }

//        public void showPopup(View view) {
//            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
//            popupMenu.setOnMenuItemClickListener(this);
//            popupMenu.inflate(R.menu.context_menu_recycler_view);
//            popupMenu.show();
//        }

//
//        @Override
//        public boolean onMenuItemClick(MenuItem menuItem) {
//            switch (menuItem.getItemId()) {
//                case R.id.options_add:
//                    for (long i =0; i<999; i++){
//                        drugList.add(new Drug("pormme", "ses bons quand ses pas trop surettaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//                        notifyDataSetChanged();
//                    }
//                    return true;
//
//                case R.id.options_remove:
//                    drugList.remove(getPosition());
//                    notifyDataSetChanged();
//
//                    return true;
//
//                default:
//                    return false;
//            }
//        }
    }
}