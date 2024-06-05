package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class BooleanVar extends PrimitiveVar<Boolean>{
    public BooleanVar(){}
    public BooleanVar(boolean b){ignoredSet(b);}
    public boolean get(){
        return wrapGet();
    }
    public void flip(){
        set(!get());
    }
    public void ignoredFlip(){
        ignoredSet(!get());
    }
}
