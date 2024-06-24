package forem.java.ui;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.functionalInterfaces.ForemUnarySetter;
import forem.java.views.VerticalLayout;

public interface ForemListView {
    static ForemElement<LinearLayout> create(ForemNullarySetter fs) {
        ScrollView scrollView = new ScrollView(ForemFocusViewGroup.focusViewGroup.getContext());
        ForemFocusView.focusView = scrollView;
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        fs.set();
        VerticalLayout verticalLayout = new VerticalLayout(scrollView.getContext());
        verticalLayout.setLayoutParams(new VerticalLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        scrollView.addView(verticalLayout);
        ForemFocusViewGroup.focusViewGroup.addView(scrollView);
        return new ForemElement<>(scrollView, verticalLayout);
    }

    static ForemElement<LinearLayout> create(ForemUnarySetter<ScrollView> fs) {
        ScrollView scrollView = new ScrollView(ForemFocusViewGroup.focusViewGroup.getContext());
        ForemFocusView.focusView = scrollView;
        fs.set(scrollView);
        VerticalLayout verticalLayout = new VerticalLayout(scrollView.getContext());
        verticalLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        scrollView.addView(verticalLayout);
        ForemFocusViewGroup.focusViewGroup.addView(scrollView);
        return new ForemElement<>(scrollView, verticalLayout);
    }
}
