package forem.java.views;

import android.content.Context;
import android.widget.LinearLayout;

import forem.java.ui.ForemFocusViewGroup;
import forem.java.ui.ForemOrigin;

public class VarArea extends LinearLayout {

    public VarArea(Context context) {
        super(context);
        if(ForemOrigin.getFocusViewGroup() instanceof VerticalLayout){
            setOrientation(VERTICAL);
        }else if(ForemOrigin.getFocusViewGroup() instanceof  HorizontalLayout){
            setOrientation(HORIZONTAL);
        }
        setWeightSum(100);
    }
}
