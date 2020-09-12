package com.practica.data.service;

import com.practica.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUsers {

    String API_ROUTE = "/users";

    @GET(API_ROUTE)
    Call<List<User>> getServices();
}
