package com.gym.sensiyar.bedehkar;

import java.util.ArrayList;

class BedehkarRepo {
    private ArrayList<BedehkarModel> list = new ArrayList<>();

    ArrayList<BedehkarModel> getList()  {
        BedehkarModel model = new BedehkarModel();
        model.setName("مهدی دیمی");
        model.setPrice("۴۰۰۰۰");
        list.add(model);

        BedehkarModel model1 = new BedehkarModel();
        model1.setName("علی صفارنیا");
        model1.setPrice("۵۰۰۰۰");
        list.add(model1);

        BedehkarModel model2 = new BedehkarModel();
        model2.setName("میلاد صفرپور");
        model2.setPrice("۳۵۰۰۰");
        list.add(model2);

        BedehkarModel model3 = new BedehkarModel();
        model3.setName("امیرعلی میرآبادی");
        model3.setPrice("۱۵۰۰۰");
        list.add(model3);

        BedehkarModel model4 = new BedehkarModel();
        model4.setName("رضا سعدآبادی");
        model4.setPrice("۱۲۰۰۰۰");
        list.add(model4);

        return list;
    }
}
