package com.example.inf1030_tp1.Services.Proxy;

import com.example.inf1030_tp1.Data.DTO.CredentialDTO;
import com.example.inf1030_tp1.Data.DTO.SessionDTO;
import com.example.inf1030_tp1.Models.Drug;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiProxy {

    @GET("pharma/data/")
    Call<List<Drug>> get();

    @POST("api/sign_in/")
    Call<SessionDTO> signIn(@Body CredentialDTO auth);
}
