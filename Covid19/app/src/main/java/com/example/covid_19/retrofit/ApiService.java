package com.example.covid_19.retrofit;

import com.example.covid_19.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET ("summary")
    Call<Response>ambildata();
}
