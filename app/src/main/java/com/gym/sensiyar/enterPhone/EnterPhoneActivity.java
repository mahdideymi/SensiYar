package com.gym.sensiyar.enterPhone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ActivityEnterPhoneBinding;
import com.gym.sensiyar.otp.OtpActivity;

import java.util.Objects;

public class EnterPhoneActivity extends AppCompatActivity {

    private EnterPhoneViewModel enterPhoneViewModel;
    private ActivityEnterPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enterPhoneViewModel = ViewModelProviders.of(this).get(EnterPhoneViewModel.class);
        binding = DataBindingUtil.setContentView(EnterPhoneActivity.this, R.layout.activity_enter_phone);

        binding.setLifecycleOwner(this);
        binding.setEnterPhoneViewModel(enterPhoneViewModel);

        enterPhoneViewModel.getUser().observe(this, enterPhoneModel -> {
            //validation register form
            if (TextUtils.isEmpty(Objects.requireNonNull(enterPhoneModel).getStrPhoneNumber())) {
                // phoneNumber is empty?
                binding.enterPhoneError.setVisibility(View.VISIBLE);
                binding.enterPhoneError.setText(getResources().getString(R.string.phone_empty));
                binding.enterPhoneEdt.requestFocus();
            } else if (!enterPhoneModel.isPhoneValidate()) { // phoneNumber is valid?
                binding.enterPhoneError.setVisibility(View.VISIBLE);
                binding.enterPhoneError.setText(getResources().getString(R.string.phone_correct));
                binding.enterPhoneEdt.requestFocus();
            } else {
                //TODO: check auth with server -> (login api call)
                Intent intent = new Intent(EnterPhoneActivity.this, OtpActivity.class);
                intent.putExtra("MOBILE" , enterPhoneModel.getStrPhoneNumber());
                startActivity(intent);
                finish();
            }
        });

    }
}
