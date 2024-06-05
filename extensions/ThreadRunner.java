package com.example.wantouch_project.forem.extensions;

public interface ThreadRunner {
    static Thread start(Runnable runnable){
        Thread thread=new Thread(runnable);
        thread.start();
        return thread;
    }
}
