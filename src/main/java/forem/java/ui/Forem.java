package forem.java.ui;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import forem.java.views.Root;

public interface Forem extends ForemOrigin {
    default ForemRoot Root() {
        Activity activity = (Activity) this;
        Root root = new Root(activity);
        root.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return new ForemRoot(activity, root);
    }

    void render(Root root);
}

