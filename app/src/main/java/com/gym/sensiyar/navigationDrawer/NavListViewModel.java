package com.gym.sensiyar.navigationDrawer;

import java.util.ArrayList;

class NavListViewModel {

    private NavListRepo navListRepo;
    NavListViewModel() {
        navListRepo = new NavListRepo();
    }

    ArrayList<NavListModel> getNavList() {
        return navListRepo.getNavList();
    }
}
