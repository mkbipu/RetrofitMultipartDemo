package com.example.user.movietune.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.user.movietune.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mMainActivity = new Intent(SplashActivity.this, MainActivity.class );
                startActivity(mMainActivity);
                finish();
            }
        }, 2500);

    }

    @Override
    public void onBackPressed() {
        if (false) {
            super.onBackPressed();
            return;
        }
    }
}
