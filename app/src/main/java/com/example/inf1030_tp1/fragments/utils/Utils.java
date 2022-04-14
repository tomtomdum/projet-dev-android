package com.example.inf1030_tp1.fragments.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.EditText;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    public static final String SHARED_PREF_USER_INFO_NAME = "SHARED_PREF_USER_INFO_NAME";
    public static final String SHARED_PREF_USER_TYPE_NAME = "SHARED_PREF_USER_TYPE_NAME";
    public static List<Drug> drugList = new ArrayList<>();
    public static Order sOrder;

    public static List<Order> sOrderList = new ArrayList<>();

    public static void setDrugList(Drug drug){
        if(drugList.indexOf(drug) == -1)
            drugList.add(drug);
    }
    public static void setOrderQuantity(int quantity, int position){
//        Drug drug = drugList.get(position);
//        drug.setQuantityOrder(quantity);
    }

    public static void updateDruglist(){

    }

    public static boolean checkFields(Resources res, Activity activity, EditText... editText){
        boolean empty = false;
        for(EditText editText1 : editText){
            if(editText1.getText().toString().isEmpty()){
                editText1.setHintTextColor(res.getColor(R.color.soft_red, activity.getTheme()));
                editText1.setBackgroundResource(R.drawable.edit_text_field_error);
                editText1.setOnFocusChangeListener((view, b) ->{
                    if(!b && !editText1.getText().toString().isEmpty()){
                        editText1.setBackgroundResource(R.drawable.edit_text_field);
                    }
                });
                empty = true;
            }
        }
        return empty;
    }
}
