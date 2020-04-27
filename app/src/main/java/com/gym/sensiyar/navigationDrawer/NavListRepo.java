package com.gym.sensiyar.navigationDrawer;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;

import java.util.ArrayList;

class NavListRepo {
    
    private ArrayList<NavListModel> navList = new ArrayList<>();

    @SuppressLint("NewApi")
    private
    Drawable drawable = App.getContext().getDrawable( R.drawable.ic_eye);

    @SuppressLint("NewApi")
    ArrayList<NavListModel> getNavList() {
        NavListModel model = new NavListModel();
        model.setTitle("نمایش اطلاعات مربی");
        Drawable profile = App.getContext().getDrawable( R.drawable.ic_person);
        model.setDrawable(profile);
        navList.add(model);

        NavListModel model1 = new NavListModel();
        model1.setTitle("ارسال گروهی پیام");
        Drawable sendSms = App.getContext().getDrawable( R.drawable.ic_message);
        model1.setDrawable(sendSms);
        navList.add(model1);

        NavListModel model2 = new NavListModel();
        model2.setTitle("بدهکاری ها");
        Drawable money = App.getContext().getDrawable( R.drawable.ic_attach_money);
        model2.setDrawable(money);
        navList.add(model2);

        NavListModel model3 = new NavListModel();
        model3.setTitle("هنرجویان فاقد بیمه ورزشی");
        Drawable insurance = App.getContext().getDrawable( R.drawable.ic_insurance);
        model3.setDrawable(insurance);
        navList.add(model3);

        NavListModel model4 = new NavListModel();
        model4.setTitle("پشتیبانی");
        Drawable support = App.getContext().getDrawable( R.drawable.ic_support);
        model4.setDrawable(support);
        navList.add(model4);

        NavListModel model5 = new NavListModel();
        model5.setTitle("درباره سنسی یار");
        Drawable about = App.getContext().getDrawable( R.drawable.ic_info);
        model5.setDrawable(about);
        navList.add(model5);

        NavListModel model6 = new NavListModel();
        model6.setTitle("خروج از حساب کاربری");
        Drawable logout = App.getContext().getDrawable( R.drawable.ic_logout);
        model6.setDrawable(logout);
        navList.add(model6);

        return navList;
    }
}
