package com.gym.sensiyar.home.classList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ClassListViewModel extends AndroidViewModel {

    private ClassListRepo classListRepo;

    public ClassListViewModel(@NonNull Application application) {
        super(application);
        classListRepo = new ClassListRepo();
    }

    public LiveData<List<ClassListModel>> getAllClassList() {
        return classListRepo.getMutableLiveDataClassList();
    }
}
