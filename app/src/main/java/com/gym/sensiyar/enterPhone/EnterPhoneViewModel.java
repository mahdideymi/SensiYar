package com.gym.sensiyar.enterPhone;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnterPhoneViewModel extends ViewModel {
    public MutableLiveData<String> phoneNumber = new MutableLiveData<>();

    private MutableLiveData<EnterPhoneModel> userLoginLiveData = new MutableLiveData<>();

    MutableLiveData<EnterPhoneModel> getUser() {
        if (userLoginLiveData == null) {
            userLoginLiveData = new MutableLiveData<>();
        }

        return userLoginLiveData;
    }

    public void onClick(View view) {
        EnterPhoneModel enterPhoneModel = new EnterPhoneModel(phoneNumber.getValue());
        userLoginLiveData.setValue(enterPhoneModel);
    }
}
