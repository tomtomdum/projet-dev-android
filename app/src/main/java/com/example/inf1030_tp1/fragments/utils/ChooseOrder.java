package com.example.inf1030_tp1.fragments.utils;

import com.example.inf1030_tp1.Models.Drug;

import java.util.ArrayList;
import java.util.List;

public class ChooseOrder {
    public static List<Drug> drugList = new ArrayList<>();

    public static void setDrugList(Drug drug){
        drugList.add(drug);
    }
}