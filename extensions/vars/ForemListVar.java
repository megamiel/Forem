package com.example.wantouch_project.forem.extensions.vars;

import com.example.wantouch_project.forem.extensions.ForemList;
import com.example.wantouch_project.forem.functionalInterfaces.ForemForEachSetter;
import com.example.wantouch_project.forem.functionalInterfaces.ForemMapSetter;
import com.example.wantouch_project.forem.functionalInterfaces.ForemUnarySetter;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
public class ForemListVar<E> extends Var<ForemList<E>>{
    public ForemListVar(){}
    public ForemListVar(ForemList<E> list){ignoredSet(list);}
    public E get(int index){
        return get().get(index);
    }

    public E set(int index,E element){
        E ret= get().set(index,element);
        ignite();
        return ret;
    }

    public boolean add(E element){
        boolean ret= get().add(element);
        ignite();
        return ret;
    }

    public void add(int index,E element){
        get().add(index,element);
        ignite();
    }

    public boolean addAll(Collection<? extends E> c){
        boolean ret= get().addAll(c);
        ignite();
        return ret;
    }

    public boolean addAll(int index, Collection<? extends E> c){
        boolean ret= get().addAll(index,c);
        ignite();
        return ret;
    }

    public void clear(){
        get().clear();
        ignite();
    }

    public boolean contains(E element){
        return get().contains(element);
    }

    public int indexOf(E element){
        return get().indexOf(element);
    }

    public int lastIndexOf(E element){
        return get().lastIndexOf(element);
    }

    public boolean isEmpty(){
        return get().isEmpty();
    }

    public int size(){
        return get().size();
    }

    public void forEach(Consumer<? super E> c){
        get().forEach(c);
    }

    public void forEach(ForemForEachSetter<E> fs){
        get().forEach(fs);
    }

    public <F> ForemList<F> map(Function<E,F> func){
        return get().map(func);
    }

    public <F> ForemList<F> map(ForemMapSetter<E,F> fs){
        return get().map(fs);
    }

    public boolean remove(E element){
        boolean ret= get().remove(element);
        ignite();
        return ret;
    }

    public E remove(int index){
        E ret= get().remove(index);
        ignite();
        return ret;
    }

    public boolean removeIf(Predicate<? super E> filter){
        boolean ret= get().removeIf(filter);
        ignite();
        return ret;
    }

    public boolean removeAll(Collection<? extends E> c){
        boolean ret= get().removeAll(c);
        ignite();
        return ret;
    }

    public void sort(Comparator<? super E> c){
        get().sort(c);
        ignite();
    }


    public Stream<E> stream(){
        return get().stream();
    }

    public E ignoredSet(int index,E element){
        return get().set(index,element);
    }

    public boolean ignoredAdd(E element){
        return get().add(element);
    }

    public void ignoredAdd(int index,E element){
        get().add(index,element);
    }

    public boolean ignoredAddAll(Collection<? extends E> c){
        return get().addAll(c);
    }

    public boolean ignoredAddAll(int index, Collection<? extends E> c){
        return get().addAll(index,c);
    }

    public void ignoredClear(){
        get().clear();
    }


    public boolean ignoredRemove(E element){
        return get().remove(element);
    }

    public E ignoredRemove(int index){
        return get().remove(index);
    }

    public boolean ignoredRemoveIf(Predicate<? super E> filter){
        return get().removeIf(filter);
    }

    public boolean ignoredRemoveAll(Collection<? extends E> c){
        return get().removeAll(c);
    }

    public void ignoredSort(Comparator<? super E> c){
        get().sort(c);
    }
}
