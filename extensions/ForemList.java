package com.example.wantouch_project.forem.extensions;

import com.example.wantouch_project.forem.annotation.Component;
import com.example.wantouch_project.forem.functionalInterfaces.ForemForEachSetter;
import com.example.wantouch_project.forem.functionalInterfaces.ForemMapSetter;

import java.util.ArrayList;
import java.util.function.Function;

public class ForemList<E> extends ArrayList<E> {
    public void forEach(ForemForEachSetter<E> fs){
        for(int i=0;i<size();fs.set(get(i),i++));
    }

    public <F> ForemList<F> map(Function<E,F> fs){
        ForemList<F> newList=new ForemList<>();
        for(int i=0;i<size();newList.add(fs.apply(get(i++))));
        return newList;
    }

    public <F> ForemList<F> map(ForemMapSetter<E,F> fs){
        ForemList<F> newList=new ForemList<>();
        for(int i=0;i<size();newList.add(fs.set(get(i),i++)));
        return newList;
    }

}
