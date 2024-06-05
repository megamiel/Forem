package com.example.wantouch_project.forem.extensions.vars.viewVars;

import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;

import com.example.wantouch_project.forem.extensions.vars.Var;

public class ViewVar<V extends View> extends Var<V> {
    public ViewVar() {
    }

    public ViewVar(V v) {
        super(v);
    }

    public void setBackgroundColor(int color) {
        get().setBackgroundColor(color);
    }

    public void setLayout(int width, int height) {
        get().setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public void setLayout(int width, int height, float weight) {
        get().setLayoutParams(new LinearLayout.LayoutParams(width, height, weight));
    }

    public void setRotation(float rotation) {
        get().setRotation(rotation);
    }

    public float getRotation(){
        return get().getRotation();
    }
}
