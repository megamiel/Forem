package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class ShortVar extends PrimitiveVar<Short>{
    public ShortVar(){}
    public ShortVar(short s){ignoredSet(s);}
    public short get(){
        return wrapGet();
    }
    public void increment(){
        set((short)(get()+1));
    }

    public void decrement(){
        set((short)(get()-1));
    }

    public void increment(short value){
        set((short)(get()+value));
    }

    public void decrement(short value){
        set((short)(get()-value));
    }

    public void ignoredIncrement(){
        ignoredSet((short)(get()+1));
    }

    public void ignoredDecrement(){
        ignoredSet((short)(get()-1));
    }

    public void ignoredIncrement(short value){
        ignoredSet((short)(get()+value));
    }

    public void ignoredDecrement(short value){
        ignoredSet((short)(get()-value));
    }
}
