// import文は省略しています

@FunctionalInterface
public interface ForemComponent extends ForemOrigin {
    ForemElement<? extends View> export(Object... args);
}
