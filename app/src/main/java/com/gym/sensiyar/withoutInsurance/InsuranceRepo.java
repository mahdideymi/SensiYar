package com.gym.sensiyar.withoutInsurance;

import java.util.ArrayList;

class InsuranceRepo {
    private ArrayList<InsuranceModel> list = new ArrayList<>();

    ArrayList<InsuranceModel> getInsuranceList() {
        for (int i = 0; i < 5; i++) {
            InsuranceModel model = new InsuranceModel();
            if (i==0 || i==3)
                model.setName("مهدی دیمی");
            else if (i==1 || i==4)
                model.setName("رسول حسین پور");
            else if (i==2)
                model.setName("بهروز شهری");
            list.add(model);
        }
        return list;
    }
}
