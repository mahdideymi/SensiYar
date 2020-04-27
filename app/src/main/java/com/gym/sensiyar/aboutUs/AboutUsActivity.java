package com.gym.sensiyar.aboutUs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gym.sensiyar.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findViewById(R.id.aboutClose).setOnClickListener(view -> finish());
    }
}
