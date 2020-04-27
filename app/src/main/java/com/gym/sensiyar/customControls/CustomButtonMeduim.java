package com.gym.sensiyar.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.gym.sensiyar.App;

public class CustomButtonMeduim extends AppCompatButton {
    public CustomButtonMeduim(Context context) {
        super(context);
        init();
    }

    public CustomButtonMeduim(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButtonMeduim(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(App.FONT_MEDIUM);
    }
}
