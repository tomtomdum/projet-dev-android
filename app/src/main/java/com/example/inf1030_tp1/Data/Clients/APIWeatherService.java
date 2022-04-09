package com.example.inf1030_tp1.Data.Clients;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIWeatherService {

//    https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

//    @GET("weather?lat={lat}&lon={lon}&appid=a2bc2057f54bd49705a6d941ef1c5685")
//    Call<JSONObject> weather(@Path("lat") float lat, @Path("lon") float lon);

    @GET("weather")
    Call<JSONObject> weather(@Query("lat") float lat, @Query("lon") float lon, @Query("appid") String apiKey);

}
