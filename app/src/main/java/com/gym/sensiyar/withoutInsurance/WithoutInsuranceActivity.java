package com.gym.sensiyar.withoutInsurance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.RecyclerItemClickListener;
import com.gym.sensiyar.bedehkar.BedehkarActivity;
import com.gym.sensiyar.databinding.ActivityWithoutInsuranceBinding;

import java.util.ArrayList;

public class WithoutInsuranceActivity extends AppCompatActivity {

    ActivityWithoutInsuranceBinding binding;
    InsuranceViewModel viewModel;
    InsuranceAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_without_insurance);
        binding.setLifecycleOwner(this);
        viewModel = new InsuranceViewModel();

        recyclerView = binding.insuranceRecycler;
        adapter = new InsuranceAdapter(viewModel.getAllInsurance());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(App.getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        RegInsurance regInsurance = new RegInsurance();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        regInsurance.show(ft, RegInsurance.TAG);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        binding.insuranceClose.setOnClickListener(view -> finish());

    }
    //لبخند بزن دیوانه جان
    // لبخند تو را من دوست دارم

}
