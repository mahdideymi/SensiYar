package com.gym.sensiyar.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gym.sensiyar.enterPhone.EnterPhoneActivity;
import com.gym.sensiyar.home.HomeActivity;
import com.gym.sensiyar.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this , EnterPhoneActivity.class));
            finish();
        }, 1000);
    }
}
