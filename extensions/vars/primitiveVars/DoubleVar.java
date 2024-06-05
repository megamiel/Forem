package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class DoubleVar extends PrimitiveVar<Double>{
    public DoubleVar(){}
    public DoubleVar(double d){
        ignoredSet(d);
    }
    public double get(){
        return wrapGet();
    }

    public void increment(){
        set(get()+1);
    }

    public void decrement(){
        set(get()-1);
    }

    public void increment(double value){
        set(get()+value);
    }

    public void decrement(double value){
        set(get()-value);
    }

    public void ignoredIncrement(){
        ignoredSet(get()+1);
    }

    public void ignoredDecrement(){
        ignoredSet(get()-1);
    }

    public void ignoredIncrement(double value){
        ignoredSet(get()+value);
    }

    public void ignoredDecrement(double value){
        ignoredSet(get()-value);
    }

}
