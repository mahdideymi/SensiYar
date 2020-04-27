package com.gym.sensiyar.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gym.sensiyar.R;
import com.gym.sensiyar.addClass.AddClassDialog;
import com.gym.sensiyar.classDetail.ClassDetailActivity;
import com.gym.sensiyar.customControls.CustomButtonMeduim;
import com.gym.sensiyar.databinding.ActivityHomeBinding;
import com.gym.sensiyar.home.classList.ClassListAdapter;
import com.gym.sensiyar.home.classList.ClassListModel;
import com.gym.sensiyar.home.classList.ClassListViewModel;
import com.gym.sensiyar.home.viewPager.HomeViewPagerAdapter;
import com.gym.sensiyar.navigationDrawer.NavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ClassListAdapter.OnItemClicked {

    private ClassListViewModel classListViewModel;
    private ClassListAdapter classListAdapter;
    private ActivityHomeBinding activityHomeBinding;

    CustomButtonMeduim addClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding =
                DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
        activityHomeBinding.setLifecycleOwner(this);

        classListViewModel = ViewModelProviders.of(this).get(ClassListViewModel.class);

        RecyclerView recyclerView = activityHomeBinding.classListRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        classListAdapter = new ClassListAdapter();
        recyclerView.setAdapter(classListAdapter);
        classListAdapter.setOnClick(HomeActivity.this);
        getAllClassList();

        ViewPager viewPager = activityHomeBinding.homeViewPager;
        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter();
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40,0,40,0);
        viewPager.setPageMargin(20);
        viewPager.setAdapter(pagerAdapter);

        addClass = activityHomeBinding.homeAddClass;
        addClass.setOnClickListener(v -> {
            AddClassDialog addClassDialog = new AddClassDialog();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            addClassDialog.setCancelable(false);
            addClassDialog.show(ft , AddClassDialog.TAG);
        });

        activityHomeBinding.homeNavigation.setOnClickListener((view) -> {
            NavigationDrawer navigationDrawer = new NavigationDrawer();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            navigationDrawer.show(ft, "NavigationDrawer");
        });
    }

    private void getAllClassList() {
        classListViewModel.getAllClassList().observe(this, classListModels -> classListAdapter.setClassList((ArrayList<ClassListModel>) classListModels));
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(HomeActivity.this, ClassDetailActivity.class));
    }
}
