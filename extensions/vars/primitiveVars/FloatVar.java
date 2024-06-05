package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class FloatVar extends PrimitiveVar<Float> {
    public FloatVar() {
    }

    public FloatVar(float d) {
        ignoredSet(d);
    }

    public float get() {
        return wrapGet();
    }

    public void increment() {
        set((float) (get() + 1));
    }

    public void decrement() {
        set((float) (get() - 1));
    }

    public void increment(float value) {
        set((float) (get() + value));
    }

    public void decrement(float value) {
        set((float) (get() - value));
    }

    public void ignoredIncrement() {
        ignoredSet((float) (get() + 1));
    }

    public void ignoredDecrement() {
        ignoredSet((float) (get() - 1));
    }

    public void ignoredIncrement(float value) {
        ignoredSet((float) (get() + value));
    }

    public void ignoredDecrement(float value) {
        ignoredSet((float) (get() - value));
    }

}
