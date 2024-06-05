package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class IntVar extends PrimitiveVar<Integer>{
    public IntVar(){}
    public IntVar(int t){
        ignoredSet(t);
    }
    public int get(){
        return wrapGet();
    }

    public void increment(){
        set(get()+1);
    }

    public void decrement(){
        set(get()-1);
    }

    public void increment(int value){
        set(get()+value);
    }

    public void decrement(int value){
        set(get()-value);
    }

    public void ignoredIncrement(){
        ignoredSet(get()+1);
    }

    public void ignoredDecrement(){
        ignoredSet(get()-1);
    }

    public void ignoredIncrement(int value){
        ignoredSet(get()+value);
    }

    public void ignoredDecrement(int value){
        ignoredSet(get()-value);
    }
}
