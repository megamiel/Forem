package forem.java.ui;

import android.view.View;

@FunctionalInterface
public interface ForemComponent extends ForemOrigin {
    ForemElement<? extends View> export();
}

