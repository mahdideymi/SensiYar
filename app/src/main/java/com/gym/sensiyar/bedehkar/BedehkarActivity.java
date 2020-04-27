package com.gym.sensiyar.bedehkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gym.sensiyar.R;

public class BedehkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BedehkarAdapter bedehkarAdapter;
    BedehkarViewModel bedehkarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedehkar);

        init();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bedehkarAdapter);

        findViewById(R.id.bedehkarClose).setOnClickListener(view -> finish());
    }

    public void init() {
        recyclerView = findViewById(R.id.bedehkarRv);
        bedehkarViewModel = new BedehkarViewModel();
        bedehkarAdapter = new BedehkarAdapter(bedehkarViewModel.getBedehKarList());
    }
}
