<<<<<<< HEAD
public interface ActivityRunner {
    static void start(Activity currentActivity, Class<? extends Activity> nextActivityClass){
        Intent intent=new Intent(currentActivity,nextActivityClass);
=======
// import文は省略しています

public interface ActivityRunner {
    static void start(Activity currentActivity, Class<? extends Activity> nextActivityClass) {
        Intent intent = new Intent(currentActivity, nextActivityClass);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        currentActivity.startActivity(intent);
    }
}
