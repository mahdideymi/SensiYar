package com.gym.sensiyar.addClass;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddClassViewModel extends ViewModel {

    public MutableLiveData<String> className = new MutableLiveData<>();
    public MutableLiveData<String> classPeriod = new MutableLiveData<>();
    public MutableLiveData<String> classTime = new MutableLiveData<>();
    public MutableLiveData<String> classPrice = new MutableLiveData<>();
    public MutableLiveData<String> classAddress = new MutableLiveData<>();

    private MutableLiveData<AddClassModel> classLiveData;

    public MutableLiveData<AddClassModel> getClassLiveData() {
        if (classLiveData == null) {
            classLiveData = new MutableLiveData<>();
        }
        return classLiveData;
    }

    public void onClick(View view) {
        AddClassModel addClassModel = new AddClassModel(className.getValue() ,
                classPeriod.getValue() , classTime.getValue(), classPrice.getValue(), classAddress.getValue());
        classLiveData.setValue(addClassModel);
    }
}
