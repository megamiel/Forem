<<<<<<< HEAD
public interface Statix {
    HashMap<String,Object> staticVariables=new HashMap<>();
    static void  set(String key,Object value){
        staticVariables.put(key,value);
    }

    static <T> void setter(String key, ForemUnarySetter<T> fs){
        fs.set(get(key));
    }

    static <T> void editSet(String key, Function<T,T> func){
        set(key,func.apply(get(key)));
    }

    static <T> T get(String key){
        return (T)staticVariables.get(key);
=======
// import文は省略しています

public interface Statix {
    HashMap<String, Object> staticVariables = new HashMap<>();

    static void set(String key, Object value) {
        staticVariables.put(key, value);
    }

    static <T> void setter(String key, ForemUnarySetter<T> fs) {
        fs.set(get(key));
    }

    static <T> void editSet(String key, Function<T, T> func) {
        set(key, func.apply(get(key)));
    }

    static <T> T get(String key) {
        return (T) staticVariables.get(key);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
    }
}
