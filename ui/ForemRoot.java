<<<<<<< HEAD
public class ForemRoot {
    private final Activity activity;
    private final Root linearLayout;
    protected ForemRoot(Activity activity, Root linearLayout){
        this.activity=activity;
        this.linearLayout=linearLayout;
    }

    public void render(ForemNullarySetter fs){
        ForemFocusViewGroup.focusViewGroup=linearLayout;
=======
// import文は省略しています

public class ForemRoot {
    private final Activity activity;
    private final Root linearLayout;

    protected ForemRoot(Activity activity, Root linearLayout) {
        this.activity = activity;
        this.linearLayout = linearLayout;
    }

    public void render(ForemNullarySetter fs) {
        ForemFocusViewGroup.focusViewGroup = linearLayout;
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        fs.set();
        activity.setContentView(linearLayout);
    }

<<<<<<< HEAD
    public void render(ForemUnarySetter<Root> fs){
        ForemFocusViewGroup.focusViewGroup=linearLayout;
=======
    public void render(ForemUnarySetter<Root> fs) {
        ForemFocusViewGroup.focusViewGroup = linearLayout;
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        fs.set(linearLayout);
        activity.setContentView(linearLayout);
    }
}
