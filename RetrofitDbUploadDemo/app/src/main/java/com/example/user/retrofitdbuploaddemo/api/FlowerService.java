package com.example.user.retrofitdbuploaddemo.api;

import com.example.user.retrofitdbuploaddemo.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>>getAllFlower();
}
