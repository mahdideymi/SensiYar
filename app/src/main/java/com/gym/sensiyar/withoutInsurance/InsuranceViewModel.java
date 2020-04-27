package com.gym.sensiyar.withoutInsurance;

import java.util.ArrayList;

class InsuranceViewModel {

    private InsuranceRepo insuranceRepo;

    InsuranceViewModel() {
        insuranceRepo = new InsuranceRepo();
    }

    ArrayList<InsuranceModel> getAllInsurance() {
        return insuranceRepo.getInsuranceList();
    }
}
