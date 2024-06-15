package forem.java.ui;

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

import forem.java.activitys.ForemActivity;
import forem.java.extensions.Args;
import forem.java.extensions.CLASS;
import forem.java.extensions.ForemFunctions;
import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.functionalInterfaces.ForemUnarySetter;
import forem.java.views.VarArea;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public interface ForemOrigin extends ForemFunctions {
    ForemActivity[] activity={null};
    int match_parent = LinearLayout.LayoutParams.MATCH_PARENT;
    int wrap_content = LinearLayout.LayoutParams.WRAP_CONTENT;
    int vertical = LinearLayout.VERTICAL;
    int horizontal = LinearLayout.HORIZONTAL;

    private LinearLayout.LayoutParams layoutParams(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }

    private LinearLayout.LayoutParams layoutParams(int width, int height, int weight) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);
        lp.weight = weight;
        return lp;
    }

    default void layoutView(View view, int width, int height) {
        view.setLayoutParams(layoutParams(width, height));
    }

    default void layoutView(View view, int width, int height, int weightPercent) {
        view.setLayoutParams(layoutParams(width, height, weightPercent));
    }

    default void layout(int widthAndHeight) {
        layoutView(ForemFocusView.focusView, widthAndHeight, widthAndHeight);
    }

    default void layout(int width, int height) {
        layoutView(ForemFocusView.focusView, width, height);
    }

    default void layout(int width, int height, int weightPercent) {
        layoutView(ForemFocusView.focusView, width, height, weightPercent);
    }

    default void id(String id) {
        ForemFocusView.focusView.setId(id.hashCode());
    }

    default <V extends View> V findViewById(String id) {
        return activity[v].findViewById(id.hashCode());
    }

    default void weightSum(int weight) {
        ((LinearLayout) ForemFocusView.focusView).setWeightSum(weight);
    }

    default void text(String text) {
        ((TextView) ForemFocusView.focusView).setText(text == null ? "null" : text);
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

    default void backgroundResource(int resouceId) {
        ForemFocusView.focusView.setBackgroundResource(resouceId);
    }

    default void image(int drawableId) {
        ((ImageView) ForemFocusView.focusView).setImageResource(drawableId);
    }

    String center = "center";
    String right = "right";
    String top = "top";
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
        if (positionList.contains(top)) {
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

    private void clearChild() {
        ForemFocusViewGroup.focusViewGroup.removeAllViews();
    }

    default <V extends View> ForemElement<V> create(ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement =
                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
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
            ForemElement<V> newForemElement =
                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


//    default <V extends View> ForemElement<V> create(Var<V> var, ForemNullarySetter fs,
//                                                    V... ignore) {
//        assert ignore.length == 0;
//        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
//        try {
//            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
//            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
//            var.set(instance);
//            ForemFocusView.focusView = instance;
//            ForemElement<V> newForemElement =
//                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
//            return newForemElement.attribute(fs);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }

    default <V extends View> ForemElement<V> create(V[] var, ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            set(var, instance);
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement =
                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends View> ForemElement<V> create(V[] var, ForemUnarySetter<V> fs, V... ignore) {
        assert ignore.length == 0;
        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
        try {
            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            set(var, instance);
            ForemFocusView.focusView = instance;
            ForemElement<V> newForemElement =
                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            return newForemElement.attribute(fs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    default <V extends VarArea> ForemElement<VarArea> create(ForemNullarySetter fs) {
        try {
            Constructor<VarArea> constructor = VarArea.class.getDeclaredConstructor(Context.class);
            VarArea instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
            ForemFocusView.focusView = instance;
            ForemElement<VarArea> newForemElement =
                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
            ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
            ForemFocusViewGroup.focusViewGroup = newForemElement.getV();
            newForemElement.attribute(fs);
            ForemFocusViewGroup.focusViewGroup = parent;
            return newForemElement;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    default <V extends
//            View> ForemElement<V> create(Var<V> var, ForemUnarySetter<V> fs,
//                                         V... ignore) {
//        assert ignore.length == 0;
//        Class<V> clazz = (Class<V>) ignore.getClass().getComponentType();
//        try {
//            Constructor<V> constructor = clazz.getDeclaredConstructor(Context.class);
//            V instance = constructor.newInstance(ForemFocusViewGroup.focusViewGroup.getContext());
//            var.set(instance);
//            ForemFocusView.focusView = instance;
//            ForemElement<V> newForemElement =
//                    new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
//            return newForemElement.attribute(fs);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }


    default void url(String url) {
        ((WebView) ForemFocusView.focusView).loadUrl(url);
    }

    default void space(int width, int height) {
        this.<Space>create(space -> layoutView(space, width, height));
    }

    default void space(int width, int height, int weightPercent) {
        this.<Space>create(space -> layoutView(space, width, height, weightPercent));
    }

    default ForemComponent component(ForemComponent fc) {
        return fc;
    }


    default <A extends Args> ForemUnaryComponentWrapper<A> component(A a, ForemUnaryComponent<A> fc) {
        return new ForemUnaryComponentWrapper<>(fc, a);
    }

    default <C> ForemUnaryComponent<C> component(Class<C> clazz, ForemUnaryComponent<C> fc) {
        return fc;
    }

    default void export(Class<? extends ForemComponent> clazz) {
        newInstance(clazz).export();
    }

    default <C extends Component> void export(ForemUnarySetter<C> fs,C... ignore){
        Class<C> clazz=cast(ignore.getClass().getComponentType());
        try {
            Constructor<C> constructor = clazz.getDeclaredConstructor();
            C instance = constructor.newInstance();
            fs.set(instance);
            instance.export();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    default void craftmincho() {
        Typeface craftmincho = Typeface.createFromAsset(activity[v].getAssets(), "craftmincho.otf");
        ((TextView) ForemFocusView.focusView).setTypeface(craftmincho);
    }

    default void font(String fontName) {
        Typeface typeface = Typeface.createFromAsset(activity[v].getAssets(), fontName);
        ((TextView) ForemFocusView.focusView).setTypeface(typeface);
    }


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

    default <C extends CLASS> C[] varType(C clazz) {
        return var((C) clazz.clone());
    }

    private <E> void varArea(E[] e, ForemNullarySetter fs) {
        fs.set();
        onChange(e, () -> {
            clearChild();
            fs.set();
        });
    }

    default <E> void onNotify(E[] e, ForemNullarySetter fs) {
        varArea(e, fs);
    }

    default <E> void notify(E[] e) {
        ignite(e);
    }

    default <E> void notify(E[] e, Object ignore) {
        ignite(e);
    }

    default <E> void notify(E[] e, ForemNullarySetter fs) {
        fs.set();
        ignite(e);
    }


    private <E> void set(E[] var, E value) {
        var[v] = value;
        if (ForemOnChangeEventScope.onChangeMap.containsKey(var)) {
            ForemOnChangeEventScope.onChangeMap.get(var).forEach(fs -> {
                ((ForemUnarySetter<E>) fs).set(value);
            });
        }
    }

    @Deprecated
    default <E> E get(E[] var) {
        return var[v];
    }

    @Deprecated
    default <E> void setter(E[] var, ForemNullarySetter fs) {
        fs.set();
        ignite(var);
    }


    private <E> void ignite(E[] var) {
        set(var, var[v]);
    }

    @Deprecated
    private <E> void onChange(E[] var, ForemUnarySetter<E> fs) {
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

    private <E> void onChange(E[] var, ForemNullarySetter fs) {
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


    default void onClick(ForemNullarySetter fs) {
        ForemOnClickEventScope.render(ForemFocusView.focusView, fs);
    }

    default <T> void onLongClick(ForemNullarySetter fs) {
        ForemOnLongClickEventScope.render(ForemFocusView.focusView, fs);
    }

    static ViewGroup getFocusViewGroup() {
        return ForemFocusViewGroup.focusViewGroup;
    }

    static void setFocusViewGroup(ViewGroup viewGroup) {
        ForemFocusViewGroup.focusViewGroup = viewGroup;
    }

    static View getFocusView() {
        return ForemFocusView.focusView;
    }

    static void setFocusView(View view) {
        ForemFocusView.focusView = view;
    }
}
