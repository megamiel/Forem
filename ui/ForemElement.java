<<<<<<< HEAD
public class ForemElement<V extends View>{
    private final ViewGroup viewGroup;
    private final V v;
    public ForemElement(ViewGroup viewGroup, V v){
        this.viewGroup=viewGroup;
        this.v=v;
    }

    protected ForemElement<V> attribute(ForemNullarySetter fs){
        fs.set();
        try {
            viewGroup.addView(v);
        }catch(IllegalStateException ignored){
=======
// import文は省略しています

public class ForemElement<V extends View> {
    private final ViewGroup viewGroup;
    private final V v;

    public ForemElement(ViewGroup viewGroup, V v) {
        this.viewGroup = viewGroup;
        this.v = v;
    }

    protected ForemElement<V> attribute(ForemNullarySetter fs) {
        fs.set();
        try {
            viewGroup.addView(v);
        } catch (IllegalStateException ignored) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397

        }
        return this;
    }

<<<<<<< HEAD
    protected ForemElement<V> attribute(ForemUnarySetter<V> fs){
        fs.set(v);
        try {
            viewGroup.addView(v);
        }catch(IllegalStateException ignored){
=======
    protected ForemElement<V> attribute(ForemUnarySetter<V> fs) {
        fs.set(v);
        try {
            viewGroup.addView(v);
        } catch (IllegalStateException ignored) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397

        }
        return this;
    }

<<<<<<< HEAD
    public ForemElement<V> render(ForemNullarySetter fs){
        assert v instanceof ViewGroup;
        ViewGroup parent=ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup=(ViewGroup)v;
        fs.set();
        ForemFocusViewGroup.focusViewGroup=parent;
        return this;
    }

    public ForemElement<V> render(ForemUnarySetter<V> fs){
        assert v instanceof ViewGroup;
        ViewGroup parent=ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup=(ViewGroup)v;
        fs.set(v);
        ForemFocusViewGroup.focusViewGroup=parent;
        return this;
    }

    public ForemElement<V> override(ForemNullarySetter fs){
=======
    public ForemElement<V> render(ForemNullarySetter fs) {
        assert v instanceof ViewGroup;
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup = (ViewGroup) v;
        fs.set();
        ForemFocusViewGroup.focusViewGroup = parent;
        return this;
    }

    public ForemElement<V> render(ForemUnarySetter<V> fs) {
        assert v instanceof ViewGroup;
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        ForemFocusViewGroup.focusViewGroup = (ViewGroup) v;
        fs.set(v);
        ForemFocusViewGroup.focusViewGroup = parent;
        return this;
    }

    public ForemElement<V> override(ForemNullarySetter fs) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        fs.set();
        return this;
    }

<<<<<<< HEAD
    public <Accurate extends View> ForemElement<V> override(ForemUnarySetter<Accurate> fs){
=======
    public <Accurate extends View> ForemElement<V> override(ForemUnarySetter<Accurate> fs) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        fs.set((Accurate) v);
        return this;
    }

}
