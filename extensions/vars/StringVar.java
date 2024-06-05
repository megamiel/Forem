package com.example.wantouch_project.forem.extensions.vars;

import androidx.annotation.NonNull;

import com.example.wantouch_project.forem.functionalInterfaces.ForemUnarySetter;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.function.Function;

public class StringVar {
    private StringBuilder t;
    private final ArrayList<ForemUnarySetter<String>> onChangeList=new ArrayList<>();
    public StringVar(){}
    public StringVar(String t){
        this.t=new StringBuilder(t);
    }

    public void ignite(){
        for(int i=0;i<onChangeList.size();i++){
            onChangeList.get(i).set(t.toString());
        }
    }

    public void addOnChangeListener(ForemUnarySetter<String> onChange){
        onChange.set(t.toString());
        onChangeList.add(onChange);
    }

    public void set(String t){
        this.t=new StringBuilder(t);
        ignite();
    }

    public void setter(ForemUnarySetter<String> fs){
        fs.set(t.toString());
        ignite();
    }

    public void editSet(Function<String,String> func){
        set(func.apply(t.toString() ));
    }

    public void ignoredSet(String t){
        this.t=new StringBuilder(t);
    }

    public void ignoredSetter(ForemUnarySetter<String> fs){
        fs.set(t.toString());
    }

    public void ignoredEditSet(Function<String,String> func){
        ignoredSet(func.apply(t.toString()));
    }

    public String get(){
        return t.toString();
    }

    public void append(String str){
        t.append(str);
    }

    public int length(){
        return t.length();
    }

    @Override
    public boolean equals(Object o){
        return t.toString().equals(o);
    }

    @NonNull
    public String toString(){
        return t.toString();
    }
}

