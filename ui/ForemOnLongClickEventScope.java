// import文は省略しています

public interface ForemOnLongClickEventScope {
    static void render(View view, ForemNullarySetter fs) {
        ViewGroup parent = ForemFocusViewGroup.focusViewGroup;
        View self = ForemFocusView.focusView;
        view.setOnLongClickListener(v -> {
            ForemScope.render(parent, self, fs::set);
            return true;
        });
    }
}

