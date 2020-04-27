package com.gym.sensiyar.addStu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ActivityAddStuBinding;

public class AddStuActivity extends AppCompatActivity {

    private AddStuViewModel addStuViewModel;
    private ActivityAddStuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addStuViewModel = ViewModelProviders.of(this).get(AddStuViewModel.class);
        binding = DataBindingUtil.setContentView(AddStuActivity.this, R.layout.activity_add_stu);

        binding.setLifecycleOwner(this);
        binding.setAddStuViewModel(addStuViewModel);

        binding.addStuClose.setOnClickListener((view)->finish());
        binding.addStuDelFormIcon.setOnClickListener((view)->deleteForm());
        binding.addStuDelFormTxt.setOnClickListener((view)->deleteForm());
        addStuViewModel.getAddStuMutable().observe(this, addStuModel -> {
            //TODO: should validation then send to server
        });
    }

    public void deleteForm(){
        binding.addStuFullName.setText("");
        binding.addStuRegDate.setText("");
        binding.addStuPrice.setText("");
        binding.addStuPhoneNumber.setText("");
        binding.addStuParentPhoneNumber.setText("");
        binding.addStuFatherName.setText("");
        binding.addStuFatherBusiness.setText("");
        binding.addStuMotherBusiness.setText("");
        binding.addStuMotherName.setText("");
        binding.addStuAddHistoryEdt.setText("");
        binding.addStuNote.setText("");
    }
}
