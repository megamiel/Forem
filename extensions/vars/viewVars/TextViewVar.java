package com.example.wantouch_project.forem.extensions.vars.viewVars;

import android.widget.TextView;

public class TextViewVar<V extends TextView> extends ViewVar<V> {
    public TextViewVar() {
    }

    public TextViewVar(V v) {
        super(v);
    }

    public String getText() {
        return get().getText().toString();
    }

    public void setText(CharSequence text) {
        get().setText(text);
    }

    public void setTextSize(float size) {
        get().setTextSize(size);
    }

    public void setTextColor(int color) {
        get().setTextColor(color);
    }

    public String getHint(){
        return get().getHint().toString();
    }

    public void setHint(CharSequence hint) {
        get().setHint(hint);
    }

    public void setHintTextColor(int color){
        get().setHintTextColor(color);
    }
}
