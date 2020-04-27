package com.gym.sensiyar.withoutInsurance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.customControls.CustomEditTextMedium;
import com.gym.sensiyar.customControls.CustomTextViewHeavy;

import java.util.ArrayList;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.ViewHolder> {

    private ArrayList<InsuranceModel> list;

    InsuranceAdapter(ArrayList<InsuranceModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.getContext()).inflate(R.layout.item_insurance_list,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InsuranceModel model = list.get(position);
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    void setInsuranceList(ArrayList<InsuranceModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public ArrayList<InsuranceModel> getList(){
        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CustomTextViewHeavy name;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.insuranceItemText);
        }
    }
}
