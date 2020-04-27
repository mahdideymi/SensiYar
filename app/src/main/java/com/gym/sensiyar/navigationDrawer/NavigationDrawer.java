package com.gym.sensiyar.navigationDrawer;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.aboutUs.AboutUsActivity;
import com.gym.sensiyar.sendSms.SendSmsActivity;
import com.gym.sensiyar.support.SupportActivity;
import com.gym.sensiyar.coachProfile.CoachProfileActivity;
import com.gym.sensiyar.bedehkar.BedehkarActivity;
import com.gym.sensiyar.R;
import com.gym.sensiyar.RecyclerItemClickListener;
import com.gym.sensiyar.withoutInsurance.WithoutInsuranceActivity;

public class NavigationDrawer extends DialogFragment {

    private ImageView navClose;
    private RecyclerView recyclerView;
    private NavListAdapter navListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.FullScreenDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_drawer , container, false);

        init(view);

        navClose.setOnClickListener((view1) -> dismiss());

        LinearLayoutManager layoutManager = new LinearLayoutManager(App.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(navListAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                startActivity(new Intent(getActivity(), CoachProfileActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(getActivity(), SendSmsActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(getActivity(), BedehkarActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(getActivity(), WithoutInsuranceActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(getActivity(), SupportActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(getActivity(), AboutUsActivity.class));
                                break;
                            default:

                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        return view;
    }

    private void init(View view) {
        navClose = view.findViewById(R.id.navigationClose);
        recyclerView = view.findViewById(R.id.navigationRecycler);
        navListAdapter = new NavListAdapter(new NavListViewModel().getNavList());
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public int getTheme() {
        return R.style.FullScreenDialog;
    }

    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }
}
