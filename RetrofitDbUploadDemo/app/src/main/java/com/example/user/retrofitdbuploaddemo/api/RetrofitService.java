package com.example.user.retrofitdbuploaddemo.api;


import com.example.user.retrofitdbuploaddemo.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private FlowerService mFlowerService;

    public FlowerService getmFlowerService(){

        if (mFlowerService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService = retrofit.create(FlowerService.class);

        }
return mFlowerService;
    }
}
