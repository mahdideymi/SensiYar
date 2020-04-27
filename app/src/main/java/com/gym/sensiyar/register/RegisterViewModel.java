package com.gym.sensiyar.register;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> pass = new MutableLiveData<>();
    public MutableLiveData<String> confirmPass = new MutableLiveData<>();

    private MutableLiveData<RegisterModel> userRegLiveData;

    public MutableLiveData<RegisterModel> getUser() {
        if (userRegLiveData == null) {
            userRegLiveData = new MutableLiveData<>();
        }

        return userRegLiveData;
    }

    public void onClick(View view) {
        RegisterModel registerModel = new RegisterModel(email.getValue() , pass.getValue(), confirmPass.getValue());
        userRegLiveData.setValue(registerModel);
    }
}
