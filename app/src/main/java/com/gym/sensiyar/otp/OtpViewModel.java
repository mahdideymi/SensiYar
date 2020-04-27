package com.gym.sensiyar.otp;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OtpViewModel extends ViewModel {
    public MutableLiveData<String> otp = new MutableLiveData<>();

    private MutableLiveData<OtpModel> userOtp = new MutableLiveData<>();

    MutableLiveData<OtpModel> getUserOtp() {
        if (userOtp == null) {
            userOtp = new MutableLiveData<>();
        }
        return userOtp;
    }

    public void onClick(View view) {
        OtpModel otpModel = new OtpModel(otp.getValue());
        userOtp.setValue(otpModel);
    }
}
