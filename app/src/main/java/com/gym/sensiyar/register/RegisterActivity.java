 package com.gym.sensiyar.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.gym.sensiyar.home.HomeActivity;
import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ActivityRegisterBinding;
import com.gym.sensiyar.enterPhone.EnterPhoneActivity;

import java.util.Objects;

 public class RegisterActivity extends AppCompatActivity {

     private RegisterViewModel registerViewModel;
     private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        binding = DataBindingUtil.setContentView(RegisterActivity.this, R.layout.activity_register);

        binding.setLifecycleOwner(this);
        binding.setRegisterViewModel(registerViewModel);

        binding.goToLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, EnterPhoneActivity.class));
            finish();
        });

        registerViewModel.getUser().observe(this, registerModel -> {

            //validation register form
            if (TextUtils.isEmpty(Objects.requireNonNull(registerModel).getStrEmail())) { // phoneNumber is empty?
                binding.regPassError.setVisibility(View.INVISIBLE);
                binding.regConfirmPassError.setVisibility(View.INVISIBLE);

                binding.regEmailError.setVisibility(View.VISIBLE);
//                    binding.regEmailError.setText(getResources().getString(R.string.email_empty));
                binding.regEmail.requestFocus();
            } else if (!registerModel.isEmailValid()) { // phoneNumber is valid?
                binding.regPassError.setVisibility(View.INVISIBLE);
                binding.regConfirmPassError.setVisibility(View.INVISIBLE);

                binding.regEmailError.setVisibility(View.VISIBLE);
//                    binding.regEmailError.setText(getResources().getString(R.string.email_correct));
                binding.regEmail.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(registerModel).getStrPass())) { // pass is empty?
                binding.regEmailError.setVisibility(View.INVISIBLE);
                binding.regConfirmPassError.setVisibility(View.INVISIBLE);

                binding.regPassError.setVisibility(View.VISIBLE);
                binding.regPassError.setText(getResources().getString(R.string.pass_empty));
                binding.regPass.requestFocus();
            } else if (!registerModel.isPasswordLengthGreaterThan5()) { // pass is valid ?
                binding.regEmailError.setVisibility(View.INVISIBLE);
                binding.regConfirmPassError.setVisibility(View.INVISIBLE);

                binding.regPassError.setVisibility(View.VISIBLE);
                binding.regPassError.setText(getResources().getString(R.string.pass_correct));
                binding.regPass.requestFocus();
            } else if (TextUtils.isEmpty(Objects.requireNonNull(registerModel).getStrConfirmPass())) { // confirm pass is empty?
                binding.regPassError.setVisibility(View.INVISIBLE);
                binding.regEmailError.setVisibility(View.INVISIBLE);

                binding.regConfirmPassError.setVisibility(View.VISIBLE);
                binding.regConfirmPassError.setText(getResources().getString(R.string.confirm_pass_empty));
                binding.regConfirmPass.requestFocus();
            } else if (!registerModel.getStrPass().equals(registerModel.getStrConfirmPass())) { //is confirmPass equal to pass?
                binding.regEmailError.setVisibility(View.INVISIBLE);
                binding.regConfirmPassError.setVisibility(View.INVISIBLE);

                binding.regConfirmPassError.setVisibility(View.VISIBLE);
                binding.regConfirmPassError.setText(getResources().getString(R.string.confirm_pass_correct));
                binding.regConfirmPass.requestFocus();
            } else {
                //TODO: check auth with server -> (register api call)
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }

        });
    }
}
