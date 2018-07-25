package com.example.user.retrofitdbuploaddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.retrofitdbuploaddemo.adapter.FlowerAdapter;
import com.example.user.retrofitdbuploaddemo.api.RetrofitService;
import com.example.user.retrofitdbuploaddemo.helper.Constants;
import com.example.user.retrofitdbuploaddemo.model.Flower;
import com.example.user.retrofitdbuploaddemo.ui.DetailActivity;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClicklistener {

    private RecyclerView mRecyclerview;
    private RetrofitService mRetrofitService;
    private FlowerAdapter mFlowerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();

        mRetrofitService = new RetrofitService();
        Call<List<Flower>>listCall = mRetrofitService.getmFlowerService().getAllFlower();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.isSuccessful()){

                    List<Flower>flowerList = response.body();
                    for (int i =0; i<flowerList.size(); i++){
                        Flower flower  = flowerList.get(i);
                        mFlowerAdapter.addFlower(flower);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });


    }

    private void configView(){

        mRecyclerview = findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        mFlowerAdapter = new FlowerAdapter(this);
        mRecyclerview.setAdapter(mFlowerAdapter);
    }

    @Override
    public void onClick(int position) {
        Flower selectedFlower = mFlowerAdapter.getselectedFlower(position);

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER, (Serializable) selectedFlower);
        startActivity(intent);
    }
}