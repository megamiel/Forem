package forem.java.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import forem.java.activitys.ForemActivity;
import forem.java.extensions.Args;
import forem.java.extensions.CLASS;
import forem.java.extensions.ForemFunctions;
import forem.java.functionalInterfaces.ForemForEachSetter;
import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.functionalInterfaces.ForemUnarySetter;
import forem.java.views.listLayoutModules.ListLayout;
import forem.java.views.VarArea;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ForemOrigin extends ForemFunctions {
    ForemActivity[] activity = {null};

    int match_parent = LinearLayout.LayoutParams.MATCH_PARENT;
    int wrap_content = LinearLayout.LayoutParams.WRAP_CONTENT;

    default void layoutView(View view, int width, int height) {
        cast(view.getLayoutParams(), LinearLayout.LayoutParams.class).width = width;
        cast(view.getLayoutParams(), LinearLayout.LayoutParams.class).height = height;
    }

    default void layoutView(View view, int width, int height, int weightPercent) {
        cast(view.getLayoutParams(), LinearLayout.LayoutParams.class).width = width;
        cast(view.getLayoutParams(), LinearLayout.LayoutParams.class).height = height;
        cast(view.getLayoutParams(), LinearLayout.LayoutParams.class).weight = weightPercent;
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

    default int rgb(String colorCode) {
        int result = 0;
        char[] tokens = colorCode.toCharArray();
        if (colorCode.length() == 6) {
            String red = "" + tokens[0] + tokens[1];
            String green = "" + tokens[2] + tokens[3];
            String blue = "" + tokens[4] + tokens[5];
            result = Color.rgb(Integer.parseInt(red, 16), Integer.parseInt(green, 16), Integer.parseInt(blue, 16));
        } else if (colorCode.length() == 3) {
            String red = "" + tokens[0] + tokens[0];
            String green = "" + tokens[1] + tokens[1];
            String blue = "" + tokens[2] + tokens[2];
            result = Color.rgb(Integer.parseInt(red, 16), Integer.parseInt(green, 16), Integer.parseInt(blue, 16));
        } else {
            assert false : "argument colorCode's length is not 3 or 6";
        }
        return result;
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

//    int left
//    int top
//    int right
//    int bottom

    default void padding(int padding) {
        padding(padding, padding, padding, padding);
    }

    default void padding(int topAndBottom, int leftAndRight) {
        padding(topAndBottom, leftAndRight, topAndBottom, leftAndRight);
    }

    default void padding(int top, int leftAndRight, int bottom) {
        padding(top, leftAndRight, bottom, leftAndRight);
    }

    default void padding(int top, int right, int bottom, int left) {
        getFocusView().setPadding(left, top, right, bottom);
    }


    default void paddingTop(int top) {
        View view = getFocusView();
        int[] paddings = getPaddings(view);
        paddings[0] = top;
        _padding(paddings);
    }

    default void paddingRight(int right) {
        View view = getFocusView();
        int[] paddings = getPaddings(view);
        paddings[1] = right;
        _padding(paddings);
    }

    default void paddingBottom(int bottom) {
        View view = getFocusView();
        int[] paddings = getPaddings(view);
        paddings[2] = bottom;
        _padding(paddings);
    }

    default void paddingLeft(int left) {
        View view = getFocusView();
        int[] paddings = getPaddings(view);
        paddings[3] = left;
        _padding(paddings);
    }

    private int[] getPaddings(View view) {
        int top = view.getPaddingTop();
        int right = view.getPaddingRight();
        int bottom = view.getPaddingBottom();
        int left = view.getPaddingLeft();
        return new int[]{top, right, bottom, left};
    }

    private void _padding(int... paddings) {
        padding(paddings[0], paddings[1], paddings[2], paddings[3]);
    }

    default void margin(int margin) {
        margin(margin, margin, margin, margin);
    }

    default void margin(int topAndBottom, int leftAndRight) {
        margin(topAndBottom, leftAndRight, topAndBottom, leftAndRight);
    }

    default void margin(int top, int leftAndRight, int bottom) {
        margin(top, leftAndRight, bottom, leftAndRight);
    }

    default void margin(int top, int right, int bottom, int left) {
        cast(getFocusView().getLayoutParams(), LinearLayout.LayoutParams.class).setMargins(left, top, right, bottom);
    }


    default void marginTop(int top) {
        View view = getFocusView();
        int[] margins = getMargins(view);
        margins[0] = top;
        _margins(margins);
    }

    default void marginRight(int right) {
        View view = getFocusView();
        int[] margins = getMargins(view);
        margins[1] = right;
        _margins(margins);
    }

    default void marginBottom(int bottom) {
        View view = getFocusView();
        int[] margins = getMargins(view);
        margins[2] = bottom;
        _margins(margins);
    }

    default void marginLeft(int left) {
        View view = getFocusView();
        int[] margins = getMargins(view);
        margins[3] = left;
        _margins(margins);
    }

    private int[] getMargins(View view) {
        LinearLayout.LayoutParams lp = cast(view.getLayoutParams(), LinearLayout.LayoutParams.class);
        int top = lp.topMargin;
        int right = lp.rightMargin;
        int bottom = lp.bottomMargin;
        int left = lp.leftMargin;
        return new int[]{top, right, bottom, left};
    }

    private void _margins(int... margins) {
        margin(margins[0], margins[1], margins[2], margins[3]);
    }


    private void clearChild() {
        ForemFocusViewGroup.focusViewGroup.removeAllViews();
    }

    default <V extends View> ForemElement<V> create(ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0 : "argument ignore is not ignored";
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
        assert ignore.length == 0 : "argument ignore is not ignored";
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

    default <V extends View> ForemElement<V> create(V[] var, ForemNullarySetter fs, V... ignore) {
        assert ignore.length == 0 : "argument ignore is not ignored";
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
        assert ignore.length == 0 : "argument ignore is not ignored";
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

    default <V extends VarArea> ForemElement<VarArea> create(ForemNullarySetter fs, V... ignore) {
        VarArea instance = new VarArea(getFocusViewGroup().getContext());
        ForemFocusView.focusView = instance;
        ForemElement<VarArea> newForemElement = new ForemElement<>(ForemFocusViewGroup.focusViewGroup, instance);
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup = newForemElement.getV();
        newForemElement.attribute(fs);
        ForemFocusViewGroup.focusViewGroup = parent;
        return newForemElement;
    }

    default <E> void listRender(List<E> list, ForemUnarySetter<E> fs) {
        cast(getFocusView(), ListLayout.class).setList(list, (e, i) -> fs.set(e));
    }

    default <E> void listRender(List<E> list, ForemForEachSetter<E> fs) {
        cast(getFocusView(), ListLayout.class).setList(list, fs);
    }


    default void url(String url) {
        ((WebView) ForemFocusView.focusView).loadUrl(url);
    }

    default void space(int width, int height) {
        this.<Space>create(space -> layoutView(space, width, height));
    }

    default void space(int width, int height, int weightPercent) {
        this.<Space>create(space -> layoutView(space, width, height, weightPercent));
    }

    @Deprecated(forRemoval = true)
    default ForemComponent component(ForemComponent fc) {
        return fc;
    }


    @Deprecated(forRemoval = true)
    default <A extends Args> ForemUnaryComponentWrapper<A> component(A a, ForemUnaryComponent<A> fc) {
        return new ForemUnaryComponentWrapper<>(fc, a);
    }

    @Deprecated(forRemoval = true)
    default <C> ForemUnaryComponent<C> component(Class<C> clazz, ForemUnaryComponent<C> fc) {
        return fc;
    }

    @Deprecated(forRemoval = true)
    default void export(Class<? extends ForemComponent> clazz) {
        newInstance(clazz).export();
    }

    default <C extends Component> void export(C... ignore) {
        Class<C> clazz = cast(ignore.getClass().getComponentType());
        try {
            Constructor<C> constructor = clazz.getDeclaredConstructor();
            C instance = constructor.newInstance();
            instance.export();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    default <C extends Component> void export(ForemUnarySetter<C> fs, C... ignore) {
        Class<C> clazz = cast(ignore.getClass().getComponentType());
        try {
            Constructor<C> constructor = clazz.getDeclaredConstructor();
            C instance = constructor.newInstance();
            fs.set(instance);
            instance.export();
        } catch (Exception ex) {
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

    default int[] var(int e) {
        return new int[]{e};
    }

    default long[] var(long e) {
        return new long[]{e};
    }

    default short[] var(short e) {
        return new short[]{e};
    }

    default byte[] var(byte e) {
        return new byte[]{e};
    }

    default char[] var(char e) {
        return new char[]{e};
    }

    default boolean[] var(boolean e) {
        return new boolean[]{e};
    }

    default double[] var(double e) {
        return new double[]{e};
    }

    default float[] var(float e) {
        return new float[]{e};
    }

    default <E> E[] var(E e) {
        Class<E> type = (Class<E>) e.getClass();
        E[] ret = (E[]) Array.newInstance(type, 1);
        ret[v] = e;
        return ret;
    }

    default <E> E[] varType(Class<E> type) {
        return (E[]) Array.newInstance(type, 1);
    }

    @Deprecated
    default <C extends CLASS> C[] varType(C clazz) {
        return var((C) clazz.clone());
    }

    default int[] array(int... elements) {
        return elements;
    }

    default long[] array(long... elements) {
        return elements;
    }

    default short[] array(short... elements) {
        return elements;
    }

    default byte[] array(byte... elements) {
        return elements;
    }

    default char[] array(char... elements) {
        return elements;
    }

    default double[] array(double... elements) {
        return elements;
    }

    default float[] array(float... elements) {
        return elements;
    }

    default <E> E[] array(E... elements) {
        return elements;
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

    default void onChange(ForemUnarySetter<String> fs) {
        TextView view = cast(getFocusView());
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                View prev = getFocusView();
                setFocusView(view);
                fs.set(charSequence.toString());
                setFocusView(prev);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
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

    default void showToast(Object message) {
        Toast.makeText(activity[v], message.toString(), Toast.LENGTH_SHORT).show();
    }

    default void alert(String message, ForemUnarySetter<ForemAlert> fs) {
        ForemAlert alert = new ForemAlert();
        fs.set(alert);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity[v]);
        builder.setTitle(alert.title);
        builder.setMessage(message);
        builder.setPositiveButton(alert.yesText, (dialog, which) -> {
            alert.onYes.set();
            dialog.dismiss();
        });
        builder.setNegativeButton(alert.noText, (dialog, which) -> {
            alert.onNo.set();
            dialog.dismiss();
        });
        builder.create().show();
    }

    private SharedPreferences getSharedPreference() {
        return activity[v].getPreferences(Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getSharedEditor() {
        return getSharedPreference().edit();
    }

    default void putShared(String key, String value) {
        getSharedEditor().putString(key, value).apply();
    }

    default void putShared(String key, int value) {
        getSharedEditor().putInt(key, value).apply();
    }

    default void putShared(String key, float value) {
        getSharedEditor().putFloat(key, value).apply();
    }

    default void putShared(String key, long value) {
        getSharedEditor().putLong(key, value).apply();
    }

    default void putShared(String key, boolean value) {
        getSharedEditor().putBoolean(key, value).apply();
    }

    default void putShared(String key, Set<String> value) {
        getSharedEditor().putStringSet(key, value).apply();
    }

    default String getShared(String key, String undefinedValue) {
        return getSharedPreference().getString(key, undefinedValue);
    }

    default int getShared(String key, int undefinedValue) {
        return getSharedPreference().getInt(key, undefinedValue);
    }

    default float getShared(String key, float undefinedValue) {
        return getSharedPreference().getFloat(key, undefinedValue);
    }

    default long getShared(String key, long undefinedValue) {
        return getSharedPreference().getLong(key, undefinedValue);
    }

    default boolean getShared(String key, boolean undefinedValue) {
        return getSharedPreference().getBoolean(key, undefinedValue);
    }

    default Set<String> getShared(String key, Set<String> undefinedValue) {
        return getSharedPreference().getStringSet(key, undefinedValue);
    }

    default void removeShared(String key) {
        getSharedEditor().remove(key).apply();
    }

    default void clearShared() {
        getSharedEditor().clear().apply();
    }
}
