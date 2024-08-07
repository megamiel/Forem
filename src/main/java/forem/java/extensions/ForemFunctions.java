package forem.java.extensions;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Constructor;

import forem.java.ui.ForemOrigin;

public interface ForemFunctions {
    default <To> To cast(Object from) {
        return (To) from;
    }

    default <To> To cast(Object from, Class<To> clazz) {
        return (To) from;
    }

    default void loop(Runnable runnable) {
        ThreadRunner.start(() -> {
            while (true) runnable.run();
        });
    }

    default void loop(Runnable runnable, long intervalMillis) {
        startThread(() -> {
            while (true) {
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

    default <X> X newInstance(Class<X> clazz) {
        X xInstance = null;
        try {
            Constructor<X> constructor = clazz.getDeclaredConstructor();
            xInstance = constructor.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xInstance;
    }


    default <A extends Activity> void startActivity(Class<A> clazz) {
        ForemOrigin.activity[0].startActivity(new Intent(ForemOrigin.activity[0], clazz));
    }

    default Thread startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    default String format(String str, Object... args) {
        return String.format(str.replace("{}", "%s"), args);
    }

    default void log(Object log) {
        Log.d("Log", log.toString());
    }

    default void echo(Object obj) {
        Log.d("echo", obj.toString());
    }
}
