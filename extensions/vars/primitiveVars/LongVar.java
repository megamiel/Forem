package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class LongVar extends PrimitiveVar<Long>{
    public LongVar(){
    }
    public LongVar(long l){ignoredSet(l);}

    public long get(){
        return wrapGet();
    }

    public void increment(){
        set(get()+1);
    }

    public void decrement(){
        set(get()-1);
    }

    public void increment(long value){
        set(get()+value);
    }

    public void decrement(long value){
        set(get()-value);
    }

    public void ignoredIncrement(){
        ignoredSet(get()+1);
    }

    public void ignoredDecrement(){
        ignoredSet(get()-1);
    }

    public void ignoredIncrement(long value){
        ignoredSet(get()+value);
    }

    public void ignoredDecrement(long value){
        ignoredSet(get()-value);
    }
}
