package com.gym.sensiyar.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.gym.sensiyar.App;

public class CustomTextViewMedium extends AppCompatTextView {

    public CustomTextViewMedium(Context context) {
        super(context);
        init();
    }

    public CustomTextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(App.FONT_MEDIUM);
    }
}
