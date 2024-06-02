// import文は省略しています


public interface ForemOnClickEventScope {
    static void render(View view, ForemNullarySetter fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        view.setOnClickListener(v -> {
            ForemScope.render(parent, self, fs);
        });
    }
}
