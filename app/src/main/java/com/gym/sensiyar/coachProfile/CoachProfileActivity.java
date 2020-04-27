package com.gym.sensiyar.coachProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gym.sensiyar.R;

public class CoachProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_profile);

        findViewById(R.id.coachClose).setOnClickListener(view -> finish());
    }
}
