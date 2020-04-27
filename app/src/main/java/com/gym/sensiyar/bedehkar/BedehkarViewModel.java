package com.gym.sensiyar.bedehkar;

import java.util.ArrayList;

public class BedehkarViewModel {

    private BedehkarRepo bedehkarRepo;

    public BedehkarViewModel() {
        bedehkarRepo = new BedehkarRepo();
    }

    public ArrayList<BedehkarModel> getBedehKarList() {
        return bedehkarRepo.getList();
    }
}
