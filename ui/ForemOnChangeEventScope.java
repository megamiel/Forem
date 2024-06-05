package com.example.wantouch_project.forem.ui;

import android.view.View;
import android.view.ViewGroup;

import com.example.wantouch_project.forem.functionalInterfaces.ForemUnarySetter;
import com.example.wantouch_project.forem.extensions.vars.Var;

import java.util.ArrayList;
import java.util.HashMap;

public interface ForemOnChangeEventScope {
    static <T> void render(Var<T> var, ForemUnarySetter<T> fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self=ForemFocusView.focusView;
        var.addOnChangeListener(val -> {
            ForemScope.render(parent,self, () -> fs.set(val));
        });
    }
    HashMap<Object, ArrayList<ForemUnarySetter<?>>> onChangeMap=new HashMap<>();
    HashMap<Object,Object> varValueMap=new HashMap<>();
}
