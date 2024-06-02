// import文は省略しています

public class Var<T> {
    private T t;
    private final ArrayList<ForemUnarySetter<T>> onChangeList = new ArrayList<>();

    public Var() {}

    public Var(T t) {
        this.t = t;
    }

    public void ignite() {
        for (int i = 0; i < onChangeList.size(); i++) {
            onChangeList.get(i).set(t);
        }
    }

    public void addOnChangeListener(ForemUnarySetter<T> onChange) {
        onChange.set(t);
        onChangeList.add(onChange);
    }

    public void set(T t) {
        this.t = t;
        ignite();
    }

    public void setter(ForemUnarySetter<T> fs) {
        fs.set(t);
        ignite();
    }

    public void editSet(Function<T, T> func) {
        set(func.apply(t));
    }

    public void ignoredSet(T t) {
        this.t = t;
    }

    public void ignoredSetter(ForemUnarySetter<T> fs) {
        fs.set(t);
    }

    public void ignoredEditSet(Function<T, T> func) {
        t = func.apply(t);
    }

    public T get() {
        return t;
    }
}
