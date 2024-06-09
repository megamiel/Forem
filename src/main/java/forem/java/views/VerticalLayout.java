package forem.java.views;

import android.content.Context;
import android.widget.LinearLayout;

public class VerticalLayout extends LinearLayout {
    public VerticalLayout(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setWeightSum(100);
    }
}
