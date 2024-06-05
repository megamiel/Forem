package com.example.wantouch_project.forem.ui;

import android.view.View;

@FunctionalInterface
public interface ForemComponent extends ForemOrigin {
    ForemElement<? extends View> export(Object... args);
}
