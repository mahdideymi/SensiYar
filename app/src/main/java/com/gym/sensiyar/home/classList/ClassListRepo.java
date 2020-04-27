package com.gym.sensiyar.home.classList;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

class ClassListRepo {

    private ArrayList<ClassListModel> classList = new ArrayList<>();
    private MutableLiveData<List<ClassListModel>> mutableLiveDataClassList = new MutableLiveData<>();

    MutableLiveData<List<ClassListModel>> getMutableLiveDataClassList() {
        for (int i = 0; i < 6; i++) {
            ClassListModel model = new ClassListModel();
            if (i == 0) {
                model.setClassName("کلاس ایثارگران");
                model.setPeriod("روزهای زوج");
                model.setTime("ساعت: ۱۸ الی ۱۹:۳۰");
            } else if (i ==1) {
                model.setClassName("کلاس هدایت");
                model.setPeriod("روزهای زوج");
                model.setTime("ساعت ۲۰ الی ۲۱:۳۰");
            } else if (i==2) {
                model.setClassName("کلاس کوثر");
                model.setPeriod("روزهای فرد");
                model.setTime("ساعت ۱۰ الی ۱۱:۳۰");
            } else {
                model.setClassName("کلاس کوثر");
                model.setPeriod("روزهای فرد");
                model.setTime("ساعت ۱۰ الی ۱۱:۳۰");
            }
            classList.add(model);
        }

        mutableLiveDataClassList.setValue(classList);
        return mutableLiveDataClassList;
    }
}
