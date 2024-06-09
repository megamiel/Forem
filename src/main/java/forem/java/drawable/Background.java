package forem.java.drawable;

import android.graphics.drawable.GradientDrawable;

import forem.java.ui.ForemFocusView;

public abstract class Background extends GradientDrawable {
    public Background(){
        ForemFocusView.focusView.setBackground(this);
    }
}
