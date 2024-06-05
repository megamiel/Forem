package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

public class CharVar extends PrimitiveVar<Character>{
    public CharVar(){}
    public CharVar(char c){
        ignoredSet(c);
    }
    public char get(){return wrapGet();}
    public void increment(){
        set((char)(get()+1));
    }

    public void decrement(){
        set((char)(get()-1));
    }

    public void increment(int value){
        set((char)(get()+value));
    }

    public void decrement(int value){
        set((char)(get()-value));
    }

    public void ignoredIncrement(){
        ignoredSet((char)(get()+1));
    }

    public void ignoredDecrement(){
        ignoredSet((char)(get()-1));
    }

    public void ignoredIncrement(int value){
        ignoredSet((char)(get()+value));
    }

    public void ignoredDecrement(int value){
        ignoredSet((char)(get()-value));
    }
}
