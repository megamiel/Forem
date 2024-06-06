public interface ActivityRunner {
    static void start(Activity currentActivity, Class<? extends Activity> nextActivityClass){
        Intent intent=new Intent(currentActivity,nextActivityClass);
        currentActivity.startActivity(intent);
    }
}
