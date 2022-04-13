package com.example.inf1030_tp1.Data.DataConverter;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.example.inf1030_tp1.Models.Drug;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

@ProvidedTypeConverter
public class Converters {
/*
    Ces converters permettent de convertir par exemple une liste de médicaments en liste json pouvant
    etre enregistré dans la base de donnée.

    Permettent aussi de faire l'inverse et de passer de json au type désiré

    On na pas besoin d'appeler ces méthodes, rooms les utilisent automatiquement quand une liste ou
    un type non reconnu de base par rooms n'est pas annoté @Null et possede un converter
 */
    @TypeConverter
    public static ArrayList<Drug> jsonToArrayList(String value) {
        Type listType = new TypeToken<ArrayList<Drug>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String arrayListToJson(ArrayList<Drug> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public static Map<Drug, Integer> jsonToMapConverter(String value) {
        Type mapType = new TypeToken<Map<Object, Integer>>() {}.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static String mapToJsonConverter(Map<Drug, Integer> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
