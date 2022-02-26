package com.example.inf1030_tp1.Adapters;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DrugListAdapter extends RecyclerView.Adapter<DrugListAdapter.ViewHolder> implements Filterable {
    private ArrayList<Drug> drugList = new ArrayList<>();
    private ArrayList<Drug> drugListCopy; // copie de la liste originale, utilisee pour filtrer le resutlat de recherche

    private LayoutInflater inflater;

    public DrugListAdapter(Context context, ArrayList list){
        this.inflater = LayoutInflater.from(context);
        this.drugList = list;
        drugListCopy = new ArrayList<>(list);
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
        viewHolder.description.setText(drugList.get(position).getDescription());
        viewHolder.drugName.setText(drugList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return drugList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Drug> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                filteredList.addAll(drugListCopy);
            }
            else {
                String filterString = charSequence.toString().toLowerCase().trim();
                for( Drug drug: drugListCopy) {
                    if(drug.getName().toLowerCase().contains(filterString));
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            drugList.clear();
            drugList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        TextView drugName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    showPopup(view);
                }
            });

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