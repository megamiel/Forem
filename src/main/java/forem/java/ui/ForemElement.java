package forem.java.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.functionalInterfaces.ForemUnarySetter;
import forem.java.ui.listLayoutModules.ListLayout;


public class ForemElement<V extends View> {
    private final ViewGroup viewGroup;
    private final V v;

    public ForemElement(ViewGroup viewGroup, V v) {
        this.viewGroup = viewGroup;
        this.v = v;
        this.v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    protected ForemElement<V> attribute(ForemNullarySetter fs) {
        fs.set();
        try {
            viewGroup.addView(v);
        } catch (IllegalStateException ignored) {

        }
        return this;
    }

    protected ForemElement<V> attribute(ForemUnarySetter<V> fs) {
        fs.set(v);
        try {
            viewGroup.addView(v);
        } catch (IllegalStateException ignored) {

        }
        return this;
    }


    public ForemElement<V> render(ForemNullarySetter fs) {
        assert v instanceof ViewGroup && !(v instanceof ListLayout):"view element not allowed to render child elements";
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup = (ViewGroup) v;
        fs.set();
        ForemFocusViewGroup.focusViewGroup = parent;
        return this;
    }

    public ForemElement<V> render(ForemUnarySetter<V> fs) {
        assert v instanceof ViewGroup && !(v instanceof ListLayout):"view element not allowed to render child elements";
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup = (ViewGroup) v;
        fs.set(v);
        ForemFocusViewGroup.focusViewGroup = parent;
        return this;
    }

    public ForemElement<V> override(ForemNullarySetter fs) {
        fs.set();
        return this;
    }

    public <Accurate extends
            View> ForemElement<V> override(ForemUnarySetter<Accurate> fs) {
        fs.set((Accurate) v);
        return this;
    }


    protected V getV() {
        return v;
    }
}
