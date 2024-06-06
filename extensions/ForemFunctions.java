<<<<<<< HEAD
=======
// import文は省略しています

>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
public interface ForemFunctions {
    default <To> To cast(Object from) {
        return (To) from;
    }

<<<<<<< HEAD
    default <To> To cast(Object from,Class<To> clazz) {
=======
    default <To> To cast(Object from, Class<To> clazz) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        return (To) from;
    }

    default void loop(Runnable runnable) {
<<<<<<< HEAD
        ThreadRunner.start(()->{
            while(true)runnable.run();
        });
    }

    default void loop(Runnable runnable,long intervalMillis){
        startThread(()->{
            while(true){
=======
        ThreadRunner.start(() -> {
            while (true)
                runnable.run();
        });
    }

    default void loop(Runnable runnable, long intervalMillis) {
        startThread(() -> {
            while (true) {
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
                runnable.run();
                sleep(intervalMillis);
            }
        });
    }

    default void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
<<<<<<< HEAD
    default <X> X newInstance(Class<X> clazz){
        X xInstance=null;
        try {
            Constructor<X> constructor = clazz.getDeclaredConstructor();
            xInstance= constructor.newInstance();
=======

    default <X> X newInstance(Class<X> clazz) {
        X xInstance = null;
        try {
            Constructor<X> constructor = clazz.getDeclaredConstructor();
            xInstance = constructor.newInstance();
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xInstance;
    }

<<<<<<< HEAD
    default <A extends Activity> void startActivity(Class<A> clazz){
        ((Activity)this).startActivity(new Intent((Activity)this,clazz));
    }

    default Thread startThread(Runnable runnable){
        Thread thread=new Thread(runnable);
=======
    default <A extends Activity> void startActivity(Class<A> clazz) {
        ((Activity) this).startActivity(new Intent((Activity) this, clazz));
    }

    default Thread startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        thread.start();
        return thread;
    }
}
