<<<<<<< HEAD
public interface function extends ForemFunctions {
    Object abstractExe(Object... args);
    default <T> T exe(Object... args){
=======
// import文は省略しています

public interface function extends ForemFunctions {
    Object abstractExe(Object... args);

    default <T> T exe(Object... args) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        return cast(abstractExe(args));
    }
}
