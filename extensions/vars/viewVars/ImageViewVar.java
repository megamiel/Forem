package com.example.wantouch_project.forem.extensions.vars.viewVars;

import android.widget.ImageView;

public class ImageViewVar<V extends ImageView> extends ViewVar<ImageView> {
    public ImageViewVar() {
    }

    public ImageViewVar(ImageView v) {
        super(v);
    }

    public void setImageResource(int drawableId) {
        get().setImageResource(drawableId);
    }
}
