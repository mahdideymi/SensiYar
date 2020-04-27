package com.gym.sensiyar.home.classList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.ClassListItemBinding;

import java.util.ArrayList;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ClassListViewHolder> {

    private ArrayList<ClassListModel> classList;
    private OnItemClicked onClick;

    @NonNull
    @Override
    public ClassListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ClassListItemBinding classListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(App.getContext()),
                        R.layout.class_list_item , parent, false);
        return new ClassListViewHolder(classListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassListViewHolder holder, final int position) {
        ClassListModel currentClass = classList.get(position);
        holder.classListItemBinding.setClassModel(currentClass);
        holder.classListItemBinding.classListLyt.setOnClickListener(v -> onClick.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        if (classList != null) {
            return classList.size();
        } else {
            return 0;
        }
    }

    public void setClassList(ArrayList<ClassListModel> classList) {
        this.classList = classList;
        notifyDataSetChanged();
    }

    public void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }

    class ClassListViewHolder extends RecyclerView.ViewHolder{

        ClassListItemBinding classListItemBinding;
        ClassListViewHolder(@NonNull ClassListItemBinding classListItemBinding) {
            super(classListItemBinding.getRoot());

            this.classListItemBinding = classListItemBinding;
        }
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }
}
