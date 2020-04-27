package com.gym.sensiyar.classDetail.stuList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StuListViewModel extends AndroidViewModel {

    private StuListRepo stuListRepo;

    public StuListViewModel(@NonNull Application application) {
        super(application);
        stuListRepo = new StuListRepo();
    }

    public LiveData<List<StuListModel>> getStuList() {
        return stuListRepo.getStuListLiveData();
    }
}
