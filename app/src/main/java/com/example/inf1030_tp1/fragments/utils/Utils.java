package com.example.inf1030_tp1.fragments.utils;

import com.example.inf1030_tp1.Models.Drug;
import com.example.inf1030_tp1.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    public static final String SHARED_PREF_USER_INFO_NAME = "SHARED_PREF_USER_INFO_NAME";
    public static final String SHARED_PREF_USER_TYPE_NAME = "SHARED_PREF_USER_TYPE_NAME";
    public static List<Drug> drugList = new ArrayList<>();
    public static Order sOrder;
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
}
