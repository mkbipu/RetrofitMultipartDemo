package piashsotware.ltd.movietune;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openMainActivity =  new Intent(SplashAcitivity.this, MainActivity.class);
                startActivity(openMainActivity);
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
