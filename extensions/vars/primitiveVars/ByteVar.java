package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class ByteVar extends PrimitiveVar<Byte>{
    public ByteVar(){}
    public ByteVar(byte t){
        ignoredSet(t);
    }
    public byte get(){
        return wrapGet();
    }

    public void increment(){
        set((byte)(get()+1));
    }

    public void decrement(){
        set((byte)(get()-1));
    }

    public void increment(int value){
        set((byte)(get()+value));
    }

    public void decrement(int value){
        set((byte)(get()-value));
    }

    public void ignoredIncrement(){
        ignoredSet((byte)(get()+1));
    }

    public void ignoredDecrement(){
        ignoredSet((byte)(get()-1));
    }

    public void ignoredIncrement(int value){
        ignoredSet((byte)(get()+value));
    }

    public void ignoredDecrement(int value){
        ignoredSet((byte)(get()-value));
    }

}
