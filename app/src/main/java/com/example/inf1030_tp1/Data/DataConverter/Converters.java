package com.example.inf1030_tp1.Data.DataConverter;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.example.inf1030_tp1.Models.Drug;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

@ProvidedTypeConverter
public class Converters {

    @TypeConverter
    public static ArrayList<Drug> jsonToArrayList(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String arrayListToJson(ArrayList<Drug> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static Map<Drug, Integer> jsonToMapConverter(String value) {
        Type mapType = new TypeToken<Map<Drug, Integer>>() {}.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static String mapToJsonConverter(Map<Drug, Integer> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
