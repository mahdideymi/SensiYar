package com.gym.sensiyar.classDetail.editClass;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EditClassViewModel extends ViewModel {

    public MutableLiveData<String> className = new MutableLiveData<>();
    public MutableLiveData<Integer> classPeriod = new MutableLiveData<>();
    public MutableLiveData<String> classTime = new MutableLiveData<>();

    private MutableLiveData<EditClassModel> classLiveData;

    public MutableLiveData<EditClassModel> getClassLiveData() {
        if (classLiveData == null) {
            classLiveData = new MutableLiveData<>();
        }
        return classLiveData;
    }

    public void onClick(View view) {
        EditClassModel addClassModel = new EditClassModel(className.getValue() , classPeriod.getValue() , classTime.getValue());
        classLiveData.setValue(addClassModel);
    }
}
