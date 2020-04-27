package com.gym.sensiyar.stuProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gym.sensiyar.R;

public class StuProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_profile);

        findViewById(R.id.stuProfileClose).setOnClickListener(view -> finish());
    }
}
