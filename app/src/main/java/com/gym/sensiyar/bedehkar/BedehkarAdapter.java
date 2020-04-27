package com.gym.sensiyar.bedehkar;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.customControls.CustomTextViewHeavy;
import com.gym.sensiyar.customControls.CustomTextViewMedium;

import java.util.ArrayList;

public class BedehkarAdapter extends RecyclerView.Adapter<BedehkarAdapter.ViewHolder> {

    private ArrayList<BedehkarModel> list;

    public BedehkarAdapter(ArrayList<BedehkarModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.getContext()).inflate(R.layout.item_bedehkar, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BedehkarModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice()+" تومان");
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CustomTextViewMedium price;
        CustomTextViewHeavy name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.bedehkarPrice);
            name = itemView.findViewById(R.id.bedehkarName);
        }
    }
}
