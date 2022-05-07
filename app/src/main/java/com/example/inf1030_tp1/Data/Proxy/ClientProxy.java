package com.example.inf1030_tp1.Data.Proxy;

import com.example.inf1030_tp1.Models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientProxy {

    @GET("client/getAll/")
    Call<List<Client>> getAllClients();

//    @GET("client/get/{id}")
//    Call<List<Client>> getClient(@Path("id") String id);
}