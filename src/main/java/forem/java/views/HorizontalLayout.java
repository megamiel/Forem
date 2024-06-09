package forem.java.views;

import android.content.Context;
import android.widget.LinearLayout;

public class HorizontalLayout extends LinearLayout {
    public HorizontalLayout(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        setWeightSum(100);
    }
}
