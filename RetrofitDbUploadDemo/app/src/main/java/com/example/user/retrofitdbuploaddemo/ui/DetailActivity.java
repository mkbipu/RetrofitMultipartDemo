package com.example.user.retrofitdbuploaddemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.NoCopySpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.retrofitdbuploaddemo.R;
import com.example.user.retrofitdbuploaddemo.helper.Constants;
import com.example.user.retrofitdbuploaddemo.model.Flower;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView mName, mId, mCatagory;
    private ImageView mPhoto;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        configviews();

        mId.setText(""+flower.getProductId());
        mName.setText(flower.getName());
        mCatagory.setText(flower.getCategory());

        Picasso.with(getApplicationContext())
                .load("http://services.hanselandpetal.com/photos/"+flower.getPhoto())
                .into(mPhoto);

    }

    private void configviews(){

        mName = findViewById(R.id.tittletxt);
        mId = findViewById(R.id.idtxt);
        mCatagory = findViewById(R.id.catagotytxt);
        mPhoto = findViewById(R.id.detailimg);

    }
}
