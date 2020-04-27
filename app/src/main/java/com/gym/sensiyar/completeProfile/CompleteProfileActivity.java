package com.gym.sensiyar.completeProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ActivityCompleteProfileBinding;
import com.gym.sensiyar.home.HomeActivity;

import org.w3c.dom.Text;

public class CompleteProfileActivity extends AppCompatActivity {

    private CompleteProfileViewModel completeProfileViewModel;
    private ActivityCompleteProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        completeProfileViewModel = ViewModelProviders.of(this).get(CompleteProfileViewModel.class);
        binding = DataBindingUtil.setContentView(CompleteProfileActivity.this, R.layout.activity_complete_profile);
        binding.setLifecycleOwner(this);
        binding.setCompleteViewModel(completeProfileViewModel);

        completeProfileViewModel.getProfileModel().observe(this, new Observer<CompleteProfileModel>() {
            @Override
            public void onChanged(CompleteProfileModel completeProfileModel) {
                if (TextUtils.isEmpty(completeProfileModel.getFullName())) {
                    binding.completeProfileFullNameErr.setVisibility(View.VISIBLE);
                    binding.completeProfileFieldErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileStateErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileCityErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileBirthdayErr.setVisibility(View.INVISIBLE);

                    binding.completeProfileFullNameErr.setText("نام و نام خانوادگی را وارد نمایید");
                } else if (completeProfileModel.getFullName().length() < 7) {
                    binding.completeProfileFullNameErr.setVisibility(View.VISIBLE);
                    binding.completeProfileFieldErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileStateErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileCityErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileBirthdayErr.setVisibility(View.INVISIBLE);

                    binding.completeProfileFullNameErr.setText("نام و نام خانوادگی نمی تواند کمتر از ۷ حرف باشد");
                }

                else if (TextUtils.isEmpty(completeProfileModel.getField())) {
                    binding.completeProfileFullNameErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileFieldErr.setVisibility(View.VISIBLE);
                    binding.completeProfileStateErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileCityErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileBirthdayErr.setVisibility(View.INVISIBLE);

                    binding.completeProfileFieldErr.setText("رشته رزمی خود را وارد نمایید");
                } else if (TextUtils.isEmpty(completeProfileModel.getState())) {
                    binding.completeProfileFullNameErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileFieldErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileStateErr.setVisibility(View.VISIBLE);
                    binding.completeProfileCityErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileBirthdayErr.setVisibility(View.INVISIBLE);

                    binding.completeProfileStateErr.setText("استان خود را وارد نمایید");
                } else if (TextUtils.isEmpty(completeProfileModel.getCity())) {
                    binding.completeProfileFullNameErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileFieldErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileStateErr.setVisibility(View.INVISIBLE);
                    binding.completeProfileCityErr.setVisibility(View.VISIBLE);
                    binding.completeProfileBirthdayErr.setVisibility(View.INVISIBLE);

                    binding.completeProfileCityErr.setText("شهر خود را وارد نمایید");
                }
//                else if (TextUtils.isEmpty(completeProfileModel.getBirthDay())) {
//                    binding.completeProfileFullNameErr.setVisibility(View.INVISIBLE);
//                    binding.completeProfileFieldErr.setVisibility(View.INVISIBLE);
//                    binding.completeProfileStateErr.setVisibility(View.INVISIBLE);
//                    binding.completeProfileCityErr.setVisibility(View.INVISIBLE);
//                    binding.completeProfileBirthdayErr.setVisibility(View.VISIBLE);
//
//                    binding.completeProfileBirthdayErr.setText("تاریخ تولد را انتخاب کنید");
//                }
                else {
                    startActivity(new Intent(CompleteProfileActivity.this, HomeActivity.class));
                }
            }
        });
    }
}
