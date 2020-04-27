package com.gym.sensiyar.classDetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.stuProfile.StuProfileActivity;
import com.gym.sensiyar.R;
import com.gym.sensiyar.addStu.AddStuActivity;
import com.gym.sensiyar.classDetail.editClass.EditClassDialog;
import com.gym.sensiyar.classDetail.popUp.PopupAdapter;
import com.gym.sensiyar.classDetail.popUp.PopupModel;
import com.gym.sensiyar.classDetail.stuList.StuListAdapter;
import com.gym.sensiyar.classDetail.stuList.StuListModel;
import com.gym.sensiyar.classDetail.stuList.StuListViewModel;
import com.gym.sensiyar.databinding.ActivityClassDetailBinding;
import com.gym.sensiyar.deleteDialog.DeleteDialog;

import java.util.ArrayList;
import java.util.List;

public class ClassDetailActivity extends AppCompatActivity implements StuListAdapter.OnItemClicked {

    private ActivityClassDetailBinding binding;
    private StuListViewModel stuListViewModel;
    private StuListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(ClassDetailActivity.this, R.layout.activity_class_detail);
        binding.setLifecycleOwner(this);

        stuListViewModel = ViewModelProviders.of(this).get(StuListViewModel.class);

        RecyclerView recyclerView = binding.classDetailStuRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(App.getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new StuListAdapter();
        adapter.setOnItemClicked(ClassDetailActivity.this);
        recyclerView.setAdapter(adapter);
        getAllStu();

        binding.classDetailClose.setOnClickListener(v -> finish());

        binding.classDetailPopUp.setOnClickListener(this::showListPopupWindow);

        binding.classDetailAddStu.setOnClickListener(v -> {
//            AddStuDialog addStuDialog = new AddStuDialog();
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            addStuDialog.setCancelable(false);
//            addStuDialog.show(ft , AddStuDialog.TAG);
            startActivity(new Intent(ClassDetailActivity.this, AddStuActivity.class));
        });

    }

    private void getAllStu() {
        stuListViewModel.getStuList().observe(this, stuListModels -> adapter.setStuList((ArrayList<StuListModel>) stuListModels));
    }

    private void showListPopupWindow(View anchor) {
        List<PopupModel> listPopupItems = new ArrayList<>();
        listPopupItems.add(new PopupModel("ویرایش اطلاعات کلاس"));
        listPopupItems.add(new PopupModel("حذف کلاس"));

        final ListPopupWindow listPopupWindow =
                createListPopupWindow(anchor, listPopupItems);
        listPopupWindow.setOnItemClickListener((parent, view, position, id) -> {
            listPopupWindow.dismiss();
            switch (position){
                case 0:
                    EditClassDialog editClassDialog = new EditClassDialog();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    editClassDialog.setCancelable(false);
                    editClassDialog.show(ft, EditClassDialog.TAG);
                    break;
                case 1:
                    DeleteDialog deleteDialog = new DeleteDialog();
                    FragmentTransaction ftDelete = getSupportFragmentManager().beginTransaction();
                    deleteDialog.show(ftDelete , DeleteDialog.TAG);
                    break;
            }
        });
        listPopupWindow.show();
    }

    private ListPopupWindow createListPopupWindow(View anchor,
                                                  List<PopupModel> items) {
        final ListPopupWindow popup = new ListPopupWindow(this);
        ListAdapter adapter = new PopupAdapter(items);
        popup.setAnchorView(anchor);
        popup.setWidth(500);
        popup.setAdapter(adapter);
        return popup;
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(ClassDetailActivity.this, StuProfileActivity.class));
    }
}
