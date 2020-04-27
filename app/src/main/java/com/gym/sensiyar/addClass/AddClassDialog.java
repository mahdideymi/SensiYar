package com.gym.sensiyar.addClass;

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
import androidx.fragment.app.DialogFragment;

import com.gym.sensiyar.R;
import com.gym.sensiyar.customControls.CustomTextViewMedium;

public class AddClassDialog extends DialogFragment {

    public static final String TAG = "EditClassDialog";
    public static final String TAGG = "EditClassDialog";
    private String headerStr = null, buttonStr = null;
    public static final String HEADER_KEY = "HEADER", BUTTON_KEY = "BUTTON";
    private AddClassViewModel addClassViewModel;

    private ImageView closeImgView;
    private CustomTextViewMedium closeTxtView;

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

        View view = inflater.inflate(R.layout.dialog_add_class, container , false);

        init(view);

        closeImgView.setOnClickListener(v -> dismiss());
        closeTxtView.setOnClickListener(v -> dismiss());

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        return view;
    }

    private void init(View view) {
        closeImgView = view.findViewById(R.id.addClassClose);
        closeTxtView = view.findViewById(R.id.addClassCloseTxt);
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
