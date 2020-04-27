package com.gym.sensiyar.classDetail.editClass;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.gym.sensiyar.App;
import com.gym.sensiyar.R;
import com.gym.sensiyar.databinding.DialogAddClassBinding;
import com.gym.sensiyar.databinding.DialogEditClassBinding;

public class EditClassDialog extends DialogFragment {

    public static final String TAG = "EditClassDialog";
    private String headerStr = null, buttonStr = null;
    public static final String HEADER_KEY = "HEADER", BUTTON_KEY = "BUTTON";
    private EditClassViewModel editClassViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
//        headerStr = bundle.getString(HEADER_KEY);
//        buttonStr = bundle.getString(BUTTON_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DialogEditClassBinding binding = DataBindingUtil.inflate(LayoutInflater.from(App.getContext()), R.layout.dialog_edit_class , container, false);
        editClassViewModel = ViewModelProviders.of(this).get(EditClassViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setEditClassModel(editClassViewModel);

        View view = binding.getRoot();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        ImageView close = binding.editClassClose;
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int width = size.x;

        window.setLayout((int) (width * 0.85), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
    }
}
