package com.gym.sensiyar.completeProfile;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompleteProfileViewModel extends ViewModel {

    public MutableLiveData<String> fullName = new MutableLiveData<>();
    public MutableLiveData<String> field = new MutableLiveData<>();
    public MutableLiveData<String> state = new MutableLiveData<>();
    public MutableLiveData<String> city = new MutableLiveData<>();
    public MutableLiveData<String> birthDay = new MutableLiveData<>();

    private MutableLiveData<CompleteProfileModel> profileModel = new MutableLiveData<>();

    public MutableLiveData<CompleteProfileModel> getProfileModel() {
        if (profileModel == null) {
            profileModel = new MutableLiveData<>();
        }
        return profileModel;
    }

    public void onClick(View view){
        CompleteProfileModel completeProfileModel = new CompleteProfileModel(fullName.getValue(),
                field.getValue(), state.getValue(), city.getValue(), birthDay.getValue());
        profileModel.setValue(completeProfileModel);
    }
}
