package com.gym.sensiyar.classDetail.popUp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gym.sensiyar.R;
import com.gym.sensiyar.customControls.CustomTextViewLight;

import java.util.List;

public class PopupAdapter extends BaseAdapter {
    private List<PopupModel> items;

    public PopupAdapter(List<PopupModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public PopupModel getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.popup_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(getItem(position).getText());
        return convertView;
    }

    static class ViewHolder {
        CustomTextViewLight tvTitle;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.popupText);
        }
    }
}
