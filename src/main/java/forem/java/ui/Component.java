package forem.java.ui;

import java.lang.reflect.Constructor;

import forem.java.activitys.ForemActivity;
import forem.java.functionalInterfaces.ForemUnarySetter;

public abstract class Component implements ForemOrigin {
    public final ForemActivity $;

    public Component(){
        $=activity[v];
    }

    public abstract void export();
}
