package com.gym.sensiyar.addStu;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AddStuViewModel extends ViewModel {

    public MutableLiveData<String> fullNameLive = new MutableLiveData<>();
    public MutableLiveData<String> regDateLive = new MutableLiveData<>();
    public MutableLiveData<String> priceLive = new MutableLiveData<>();
    public MutableLiveData<String> phoneNumberLive = new MutableLiveData<>();
    public MutableLiveData<String> parentPhoneNumberLive = new MutableLiveData<>();
    public MutableLiveData<String> fatherNameLive = new MutableLiveData<>();
    public MutableLiveData<String> fatherBusinessLive = new MutableLiveData<>();
    public MutableLiveData<String> motherNameLive = new MutableLiveData<>();
    public MutableLiveData<String> motherBusinessLive = new MutableLiveData<>();
    public MutableLiveData<String> noteLive = new MutableLiveData<>();
    public MutableLiveData<String> bimeNumberLive = new MutableLiveData<>();
    public MutableLiveData<ArrayList<String>> historyLive = new MutableLiveData<>();
    public MutableLiveData<Boolean> priceStatusLive = new MutableLiveData<>();

    private MutableLiveData<AddStuModel> addStuMutable = new MutableLiveData<>();

    MutableLiveData<AddStuModel> getAddStuMutable() {
        if (addStuMutable == null) {
            addStuMutable = new MutableLiveData<>();
        }
        return addStuMutable;
    }

    public void onClick(View view) {
        AddStuModel addStuModel = new AddStuModel(fullNameLive.getValue(), regDateLive.getValue(),
                priceLive.getValue(), phoneNumberLive.getValue(), parentPhoneNumberLive.getValue(),
                fatherNameLive.getValue(), fatherBusinessLive.getValue(), motherBusinessLive.getValue(),
                motherNameLive.getValue(), historyLive.getValue(), noteLive.getValue());

        addStuMutable.setValue(addStuModel);
    }

}
