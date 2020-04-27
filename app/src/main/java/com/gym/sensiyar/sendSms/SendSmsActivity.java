package com.gym.sensiyar.sendSms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.fonts.Font;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.gym.sensiyar.App;
import com.gym.sensiyar.R;

public class SendSmsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabSendSmsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        init();

        findViewById(R.id.SendSmsClose).setOnClickListener(view -> finish());
        adapter.addFragment(new Fragment1(), "هنرجو");
        adapter.addFragment(new Fragment1(), "سرپرست هنرجو");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void init(){
        tabLayout = findViewById(R.id.sendSmsTabLayout);
        viewPager = findViewById(R.id.sendSmsViewPager);
        adapter = new TabSendSmsAdapter(getSupportFragmentManager(), 0);
    }
}
