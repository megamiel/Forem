package forem.java.extensions;

import forem.java.functionalInterfaces.ForemUnarySetter;

import java.util.HashMap;
import java.util.function.Function;

public class Statix {
     private static HashMap<String, Object> staticVariables = new HashMap<>();

    public static void set(String key, Object value) {
        staticVariables.put(key, value);
    }

    public static <T> void setter(String key, ForemUnarySetter<T> fs) {
        fs.set(get(key));
    }

    public static <T> void editSet(String key, Function<T, T> func) {
        set(key, func.apply(get(key)));
    }

    public static <T> T get(String key) {
        return (T) staticVariables.get(key);
    }
}
