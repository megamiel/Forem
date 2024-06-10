package forem.java.ui;

import android.content.Context;
import android.view.View;

import java.lang.reflect.Constructor;

import forem.java.extensions.CLASS;
import forem.java.functionalInterfaces.ForemUnarySetter;

public interface ForemUnaryComponent<C> {
    ForemElement<? extends View> export(C arg);
    default ForemElement<? extends View> export(C[] arg){
        return export(arg[0]);
    }
}
