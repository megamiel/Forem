<<<<<<< HEAD
public interface ForemOnLongClickEventScope {
    static void render(View view, ForemNullarySetter fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self=ForemFocusView.focusView;
        view.setOnLongClickListener(v -> {
            ForemScope.render(parent,self, fs::set);
=======
// import文は省略しています

public interface ForemOnLongClickEventScope {
    static void render(View view, ForemNullarySetter fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        view.setOnLongClickListener(v -> {
            ForemScope.render(parent, self, fs::set);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
            return true;
        });
    }
}

