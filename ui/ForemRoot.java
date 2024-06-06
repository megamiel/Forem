public class ForemRoot {
    private final Activity activity;
    private final Root linearLayout;
    protected ForemRoot(Activity activity, Root linearLayout){
        this.activity=activity;
        this.linearLayout=linearLayout;
    }

    public void render(ForemNullarySetter fs){
        ForemFocusViewGroup.focusViewGroup=linearLayout;
        fs.set();
        activity.setContentView(linearLayout);
    }

    public void render(ForemUnarySetter<Root> fs){
        ForemFocusViewGroup.focusViewGroup=linearLayout;
        fs.set(linearLayout);
        activity.setContentView(linearLayout);
    }
}
