package forem.java.extensions;

public interface ThreadRunner {
    static Thread start(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }
}
