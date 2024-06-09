package forem.java.drawable;

import android.graphics.drawable.GradientDrawable;

import forem.java.ui.ForemFocusView;

public abstract class ReusableBackground extends GradientDrawable {
    public void export(){
        ForemFocusView.focusView.setBackground(this);
    }
}
