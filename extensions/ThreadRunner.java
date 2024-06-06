<<<<<<< HEAD
public interface ThreadRunner {
    static Thread start(Runnable runnable){
        Thread thread=new Thread(runnable);
=======
// import文は省略しています

public interface ThreadRunner {
    static Thread start(Runnable runnable) {
        Thread thread = new Thread(runnable);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        thread.start();
        return thread;
    }
}
