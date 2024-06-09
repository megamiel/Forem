package forem.java.ui;

import forem.java.functionalInterfaces.ForemUnarySetter;

import java.util.ArrayList;
import java.util.HashMap;

public interface ForemOnChangeEventScope {
//    static <T> void render(Var<T> var, ForemUnarySetter<T> fs) {
//        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
//        View self = ForemFocusView.focusView;
//        var.addOnChangeListener(val -> {
//            ForemScope.render(parent, self, () -> fs.set(val));
//        });
//    }

    HashMap<Object, ArrayList<ForemUnarySetter<?>>> onChangeMap = new HashMap<>();
    HashMap<Object, Object> varValueMap = new HashMap<>();
}
