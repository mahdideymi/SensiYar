package com.gym.sensiyar.support;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gym.sensiyar.R;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        findViewById(R.id.supportClose).setOnClickListener(view -> finish());
    }
}
