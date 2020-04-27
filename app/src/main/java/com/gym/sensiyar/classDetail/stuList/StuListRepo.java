package com.gym.sensiyar.classDetail.stuList;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class StuListRepo {

    private ArrayList<StuListModel> stuList = new ArrayList<>();
    private MutableLiveData<List<StuListModel>> stuListLiveData = new MutableLiveData<>();

    public MutableLiveData<List<StuListModel>> getStuListLiveData() {
        for (int i = 0; i < 17; i++) {
            StuListModel model = new StuListModel("nothing" , "مهدی دیمی", i%2==0?true:false, "ثبت نام: ۱۳۸۸/۲/۱۶");
            stuList.add(model);
        }

        stuListLiveData.setValue(stuList);
        return stuListLiveData;
    }
}
