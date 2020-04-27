package com.gym.sensiyar.classDetail.stuList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.StuListItemBinding;

import java.util.ArrayList;

public class StuListAdapter extends RecyclerView.Adapter<StuListAdapter.StuViewHolder> {

    private ArrayList<StuListModel> stuList;
    private OnItemClicked onItemClicked;

    @NonNull
    @Override
    public StuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StuListItemBinding stuListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(App.getContext()),
                        R.layout.stu_list_item, parent, false);
        return new StuViewHolder(stuListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StuViewHolder holder, final int position) {
        StuListModel model = stuList.get(position);
        holder.stuListItemBinding.setStuModel(model);
        if(stuList.get(position).getPriceStatus())
            holder.stuListItemBinding.stuListStatus.setImageDrawable(
                    ContextCompat.getDrawable(App.getContext(), R.drawable.corner_green_1));
        else
            holder.stuListItemBinding.stuListStatus.setImageDrawable(
                    ContextCompat.getDrawable(App.getContext(), R.drawable.corner_red_1));
        holder.stuListItemBinding.stuListRegDate.setText(model.getRegDate());
        holder.stuListItemBinding.stuListLyt.setOnClickListener(v -> onItemClicked.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return stuList.size();
    }

    public void setStuList(ArrayList<StuListModel> list){
        this.stuList = list;
        notifyDataSetChanged();
    }

    public void setOnItemClicked(OnItemClicked onItemClicked){
        this.onItemClicked = onItemClicked;
    }

    class StuViewHolder extends RecyclerView.ViewHolder{

        StuListItemBinding stuListItemBinding;
        StuViewHolder(@NonNull StuListItemBinding stuListItemBinding) {
            super(stuListItemBinding.getRoot());
            this.stuListItemBinding = stuListItemBinding;
        }
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }
}
