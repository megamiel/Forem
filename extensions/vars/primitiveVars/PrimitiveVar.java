package com.example.wantouch_project.forem.extensions.vars.primitiveVars;

import com.example.wantouch_project.forem.functionalInterfaces.ForemUnarySetter;

import java.util.ArrayList;
import java.util.function.Function;

class PrimitiveVar<W>{
    private W w;
    private final ArrayList<ForemUnarySetter<W>> onChangeList=new ArrayList<>();
    public PrimitiveVar(){}
    public PrimitiveVar(W w){
        this.w=w;
    }

    public void ignite(){
        for(int i=0;i<onChangeList.size();i++){
            onChangeList.get(i).set(w);
        }
    }

    public void addOnChangeListener(ForemUnarySetter<W> onChange){
        onChange.set(w);
        onChangeList.add(onChange);
    }

    public void set(W w){
        this.w=w;
        ignite();
    }

    public void setter(ForemUnarySetter<W> fs){
        fs.set(w);
        ignite();
    }

    public void editSet(Function<W,W> func){
        set(func.apply(w));
    }

    public void ignoredSet(W w){
        this.w=w;
    }

    public void ignoredSetter(ForemUnarySetter<W> fs){
        fs.set(w);
    }

    public void ignoredEditSet(Function<W,W> func){
        w=func.apply(w);
    }

    protected W wrapGet(){
        return w;
    }
}
