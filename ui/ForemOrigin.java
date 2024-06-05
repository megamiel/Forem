package com.example.wantouch_project.forem.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;


import com.example.wantouch_project.forem.activitys.ForemActivity;
import com.example.wantouch_project.forem.extensions.ForemFunctions;
import com.example.wantouch_project.forem.extensions.ForemList;
import com.example.wantouch_project.forem.functionalInterfaces.ForemNullarySetter;
import com.example.wantouch_project.forem.functionalInterfaces.ForemUnarySetter;
import com.example.wantouch_project.forem.extensions.vars.Var;
import com.example.wantouch_project.forem.extensions.function;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public interface ForemOrigin extends ForemFunctions {
    int match_parent = LinearLayout.LayoutParams.MATCH_PARENT;
    int wrap_content = LinearLayout.LayoutParams.WRAP_CONTENT;
    int vertical = LinearLayout.VERTICAL;
    int horizontal = LinearLayout.HORIZONTAL;

    default LinearLayout.LayoutParams layoutParams(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }

    default LinearLayout.LayoutParams layoutParams(int width, int height, float weight) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);
        lp.weight = weight;
        return lp;
    }

    default void layoutView(View view, int width, int height) {
        view.setLayoutParams(layoutParams(width, height));
    }

    default void layoutView(View view, int width, int height, float weightPercent) {
        view.setLayoutParams(layoutParams(width, height, weightPercent));
    }

    default void layout(int widthAndHeight) {
        layoutView(ForemFocusView.focusView, widthAndHeight, widthAndHeight);
    }

    default void layout(int width, int height) {
        layoutView(ForemFocusView.focusView, width, height);
    }

    default void layout(int width, int height, float weightPercent) {
        layoutView(ForemFocusView.focusView, width, height, weightPercent);
    }

    default void id(String id) {
        ForemFocusView.focusView.setId(id.hashCode());
    }

    default <V extends View> V findViewById(String id) {
        return ((Activity) this).findViewById(id.hashCode());
    }

    default void weightSum(int weight) {
        ((LinearLayout) ForemFocusView.focusView).setWeightSum(weight);
    }

    default void text(String text) {
        ((TextView) ForemFocusView.focusView).setText(text);
    }

    default void textSize(float size) {
        ((TextView) ForemFocusView.focusView).setTextSize(size);
    }

    default void textColor(int color) {
        ((TextView) ForemFocusView.focusView).setTextColor(color);
    }

    default void hint(String hint) {
        ((TextView) ForemFocusView.focusView).setHint(hint);
    }

    default void hintColor(int color) {
        ((TextView) ForemFocusView.focusView).setHintTextColor(color);
    }

    default void backgroundColor(int color) {
        ForemFocusView.focusView.setBackgroundColor(color);
    }

    default void backgroundResource(int resouceId){
        ForemFocusView.focusView.setBackgroundResource(resouceId);
    }

    default void image(int drawableId) {
        ((ImageView) ForemFocusView.focusView).setImageResource(drawableId);
    }

    String center = "center";
    String right = "right";
    String top="top";
    String bottom = "bottom";
    String left = "left";

    default void align(String... positions) {
        List<String> positionList = List.of(positions);
        if (positionList.contains(center)) {
            alignCenter();
        }
        if (positionList.contains(right)) {
            alignRight();
        }
        if(positionList.contains(top)){
            alignTop();
        }
        if (positionList.contains(bottom)) {
            alignBottom();
        }
        if (positionList.contains(left)) {
            alignLeft();
        }
    }

    default void alignCenter() {
        ForemFocusView.focusView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        if (ForemFocusView.focusView instanceof TextView) {
            ((TextView) ForemFocusView.focusView).setGravity(Gravity.CENTER);
        }
    }

    default void alignLeft() {
        ForemFocusView.focusView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
    }

    default void alignRight() {
        ForemFocusView.focusView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
    }

    default void alignTop() {
        ((TextView) ForemFocusView.focusView).setGravity(Gravity.TOP);
    }

    default void alignBottom() {
        ((TextView) ForemFocusView.focusView).setGravity(Gravity.BOTTOM);
    }

    default void rotate(float angle) {
        ForemFocusView.focusView.setRotation(angle);
    }

    default void vertical(LinearLayout linearLayout) {
        linearLayout.setOrientation(vertical);
    }

    default void horizontal(LinearLayout linearLayout) {
        linearLayout.setOrientation(horizontal);
    }

    default void vertical() {
        vertical((LinearLayout) ForemFocusView.focusView);
    }

    default void horizontal() {
        horizontal((LinearLayout) ForemFocusView.focusView);
    }

    default void clearChild() {
        ForemFocusViewGroup.focusViewGroup.removeAllViews();
    }

    default <V extends View> ForemElement<V> create(ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends View> ForemElement<V> create(ForemUnarySetter<V> fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends View> ForemElement<V> create(Var<V> var, ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            var.set(instance);
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends View> ForemElement<V> create(V[] var, ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            set(var, instance);
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends View> ForemElement<V> create(Var<V> var, ForemUnarySetter<V> fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            var.set(instance);
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    default void space(int width, int height) {
        this.<Space>create(space -> layoutView(space, width, height));
    }

    default void space(int width, int height, int weightPercent) {
        this.<Space>create(space -> layoutView(space, width, height, weightPercent));
    }

    default void export(Class<? extends ForemComponent> clazz, Object... args) {
        newInstance(clazz).export(args);
    }

    default void craftmincho(){
        Typeface craftmincho = Typeface.createFromAsset(((Activity)this).getAssets(), "craftmincho.otf");
        ((TextView)ForemFocusView.focusView).setTypeface(craftmincho);
    }

    default void url(String url){
        cast(ForemFocusView.focusView, WebView.class).loadUrl(url);
    }

//    default <T> Var<T> var() {
//        return new Var<>();
//    }
//
//    default <V extends ImageView> ImageViewVar<V> var(V v){return new ImageViewVar<>(v);}
//
//    default <V extends TextView> TextViewVar<V> var(V v) {
//        return new TextViewVar<>(v);
//    }
//
//    default <V extends View> ViewVar<V> var(V v) {
//        return new ViewVar<>(v);
//    }
//
//    default BooleanVar var(boolean initialValue) {
//        return new BooleanVar(initialValue);
//    }
//
//    default CharVar var(char initialValue) {
//        return new CharVar(initialValue);
//    }
//
//    default FloatVar var(float initialValue) {
//        return new FloatVar(initialValue);
//    }
//
//    default DoubleVar var(double initialValue) {
//        return new DoubleVar(initialValue);
//    }
//
//    default ByteVar var(byte initialValue) {
//        return new ByteVar(initialValue);
//    }
//
//    default ShortVar var(short initialValue) {
//        return new ShortVar(initialValue);
//    }
//
//    default LongVar var(long initialValue) {
//        return new LongVar(initialValue);
//    }
//
//    default IntVar var(int initialValue) {
//        return new IntVar(initialValue);
//    }
//
//    default <E> ForemListVar<E> var(ForemList<E> list){
//        return new ForemListVar<>(list);
//    }
//
//    default <E> ForemListVar<E> var(E... elements){
//        ForemList<E> list=new ForemList<>();
//        for(int i=0;i<list.size();list.add(elements[i++]));
//        return new ForemListVar<>(list);
//    }
//
//    default StringVar var(String initialValue){
//        return new StringVar(initialValue);
//    }
//
//    default <T> Var<T> var(T initialValue) {
//        return new Var<>(initialValue);
//    }

//    default <V extends ImageView> ImageViewVar<V> varType(Class<V> clazz,V... ignore){
//        return new ImageViewVar<>();
//    }
//    default <V extends TextView> TextViewVar<V> varType(Class<V> clazz, V... ignore) {
//        return new TextViewVar<>();
//    }
//
//    default <V extends View> ViewVar<V> varType(Class<V> clazz, V... ignore) {
//        return new ViewVar<>();
//    }
//
//    default <T> Var<T> varType(Class<T> clazz, T... ignore) {
//        return var();
//    }

    int v = 0;

    default <E> E[] var(E e) {
        Class<E> type = (Class<E>) e.getClass();
        E[] ret = (E[]) Array.newInstance(type, 1);
        ret[v] = e;
        return ret;
    }

    default <E> E[] varType(Class<E> type) {
        return (E[]) Array.newInstance(type, 1);
    }

    default <E> void set(E[] var, E value) {
        var[v] = value;
        if (ForemOnChangeEventScope.onChangeMap.containsKey(var)) {
            ForemOnChangeEventScope.onChangeMap.get(var).forEach(fs -> {
                ((ForemUnarySetter<E>) fs).set(value);
            });
        }
    }

    default <E> E get(E[] var) {
        return var[v];
    }

    default <E> void setter(E[] var, ForemNullarySetter fs) {
        fs.set();
        ignite(var);
    }

    default <E> void ignite(E[] var) {
        set(var, var[v]);
    }

    default <E> void onChange(E[] var, ForemUnarySetter<E> fs) {
        if (!ForemOnChangeEventScope.onChangeMap.containsKey(var)) {
            ForemOnChangeEventScope.onChangeMap.put(var, new ArrayList<>());
        }
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        ForemUnarySetter<E> newFs = e -> {
            ViewGroup cacheViewGroup = ForemFocusViewGroup.focusViewGroup;
            View cacheView = ForemFocusView.focusView;
            ForemFocusViewGroup.focusViewGroup = parent;
            ForemFocusView.focusView = self;
            fs.set(e);
            ForemFocusViewGroup.focusViewGroup = cacheViewGroup;
            ForemFocusView.focusView = cacheView;
        };
        ForemOnChangeEventScope.onChangeMap.get(var).add(newFs);
    }

    default <E> void onChange(E[] var, ForemNullarySetter fs) {
        if (!ForemOnChangeEventScope.onChangeMap.containsKey(var)) {
            ForemOnChangeEventScope.onChangeMap.put(var, new ArrayList<>());
        }
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        ForemUnarySetter<E> newFs = e -> {
            ViewGroup cacheViewGroup = ForemFocusViewGroup.focusViewGroup;
            View cacheView = ForemFocusView.focusView;
            ForemFocusViewGroup.focusViewGroup = parent;
            ForemFocusView.focusView = self;
            fs.set();
            ForemFocusViewGroup.focusViewGroup = cacheViewGroup;
            ForemFocusView.focusView = cacheView;
        };
        ForemOnChangeEventScope.onChangeMap.get(var).add(newFs);
    }

//    ForemList<ForemNullarySetter> observer =new ForemList<>();

//    default <E> void testOnChange(E[] var,ForemNullarySetter fs){
//        if (!ForemOnChangeEventScope.onChangeMap.containsKey(var)) {
//            ForemOnChangeEventScope.onChangeMap.put(var, new ArrayList<>());
//        }
//        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
//        View self = ForemFocusView.focusView;
//        ForemUnarySetter<E> newFs = e -> {
//            ViewGroup cacheViewGroup = ForemFocusViewGroup.focusViewGroup;
//            View cacheView = ForemFocusView.focusView;
//            ForemFocusViewGroup.focusViewGroup = parent;
//            ForemFocusView.focusView = self;
//            fs.set();
//            ForemFocusViewGroup.focusViewGroup = cacheViewGroup;
//            ForemFocusView.focusView = cacheView;
//        };
//        ForemOnChangeEventScope.onChangeMap.get(var).add(newFs);
//
//        ForemUnarySetter<E[]> fus=arg->{
//            if(ForemOnChangeEventScope.varValueMap.get(arg)!=arg[v]){
//                ForemOnChangeEventScope.varValueMap.put(arg,arg[v]);
//                ForemOnChangeEventScope.onChangeMap.get(arg).forEach(sfs->{
//                    ((ForemUnarySetter<E>)sfs).set(arg[v]);
//                });
//            }
//        };
//        observer.add(()->fus.set(var));
//    }

//    default void testCheck(){
//        observer.forEach(ForemNullarySetter::set);
//    }

    default void onClick(ForemNullarySetter fs) {
        ForemOnClickEventScope.render(ForemFocusView.focusView, fs);
    }

    default <T> void onLongClick(ForemNullarySetter fs) {
        ForemOnLongClickEventScope.render(ForemFocusView.focusView, fs);
    }

//    default <T> void onChange(Var<T> var, ForemUnarySetter<T> fs) {
//        ForemOnChangeEventScope.render(var, fs);
//    }

    default <T> T function(function func, Object... args) {
        return cast(func.exe(args));
    }

    default <T> void focus(Var<T> var, ForemUnarySetter<T> fs) {
        fs.set(var.get());
    }
}
