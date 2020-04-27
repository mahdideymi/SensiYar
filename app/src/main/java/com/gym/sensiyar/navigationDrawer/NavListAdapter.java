package com.gym.sensiyar.navigationDrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.customControls.CustomTextViewMedium;

import java.util.ArrayList;

public class NavListAdapter extends RecyclerView.Adapter<NavListAdapter.NavListViewHolder> {

    private ArrayList<NavListModel> list;
    private OnNavItemClicked onNavItemClicked;

    NavListAdapter(ArrayList<NavListModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NavListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.getContext()).inflate(R.layout.item_nav_list, parent, false);
        return new NavListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavListViewHolder holder, int position) {
        NavListModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.icon.setImageDrawable(model.getDrawable());
        holder.navItem.setOnClickListener((view)->{
            onNavItemClicked.onNavItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) return list.size();
        else return 0;
    }

    public void setList (ArrayList<NavListModel> navListModels){
        this.list = navListModels;
        notifyDataSetChanged();
    }

    public void setOnClick(OnNavItemClicked onNavItemClicked)
    {
        this.onNavItemClicked=onNavItemClicked;
    }

    class NavListViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private CustomTextViewMedium title;
        private ConstraintLayout navItem;

        NavListViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.navItemIc);
            title = itemView.findViewById(R.id.navItemTxt);
            navItem = itemView.findViewById(R.id.navItemLyt);
        }
    }

    public interface OnNavItemClicked {
        void onNavItemClick(int position);
    }
}
