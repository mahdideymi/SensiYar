package com.gym.sensiyar.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.gym.sensiyar.App;
import com.gym.sensiyar.completeProfile.CompleteProfileActivity;
import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ActivityOtpBinding;
import com.gym.sensiyar.enterPhone.EnterPhoneActivity;
import com.gym.sensiyar.services.BroadcastService;

public class OtpActivity extends AppCompatActivity {

    private static final String TAG = "OtpActivity";
    private OtpViewModel otpViewModel;
    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        otpViewModel = ViewModelProviders.of(this).get(OtpViewModel.class);
        binding = DataBindingUtil.setContentView(OtpActivity.this , R.layout.activity_otp);

        binding.setLifecycleOwner(this);
        binding.setOtpViewModel(otpViewModel);

        startService(new Intent(this, BroadcastService.class));
        Log.i(TAG, "Started service");

        binding.otpEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 4 && s.toString().equals("1234")) {
                    stopService(new Intent(OtpActivity.this, BroadcastService.class));
                    startActivity(new Intent(OtpActivity.this, CompleteProfileActivity.class));
                    finish();
                } else if (s.length() == 4 && !s.toString().equals("1234")) {
                    App.toast("تایید رمز عبور اشتباه وارد شد.");
                    binding.otpEdt.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.otpChangePhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpActivity.this, EnterPhoneActivity.class));
                finish();
            }
        });
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent); // or whatever method used to update your GUI fields
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(BroadcastService.COUNTDOWN_BR));
        Log.i(TAG, "Registered broacast receiver");
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(br);
        Log.i(TAG, "Unregistered broacast receiver");
    }

    @Override
    public void onStop() {
        try {
            unregisterReceiver(br);
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
        super.onStop();
    }
    @Override
    public void onDestroy() {
        stopService(new Intent(this, BroadcastService.class));
        Log.i(TAG, "Stopped service");
        super.onDestroy();
    }

    @SuppressLint("SetTextI18n")
    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            long millisUntilFinished = intent.getLongExtra("countdown", 0);
            Log.i(TAG, "Countdown seconds remaining: " +  millisUntilFinished / 1000);
            binding.otpCountDowner.setText(millisUntilFinished/1000 + " ثانیه تا دریافت کد جدید");
        }
    }
}
