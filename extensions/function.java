// import文は省略しています

public interface function extends ForemFunctions {
    Object abstractExe(Object... args);

    default <T> T exe(Object... args) {
        return cast(abstractExe(args));
    }
}
