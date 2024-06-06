<<<<<<< HEAD
=======
// import文は省略しています


>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
public interface ForemOnClickEventScope {
    static void render(View view, ForemNullarySetter fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        view.setOnClickListener(v -> {
<<<<<<< HEAD
            ForemScope.render(parent,self, fs);
=======
            ForemScope.render(parent, self, fs);
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
        });
    }
}
