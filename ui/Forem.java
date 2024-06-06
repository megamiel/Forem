public interface Forem extends ForemOrigin {
    default ForemRoot Root() {
        Activity activity = (Activity) this;
        Root root = new Root(activity);
        layoutView(root, match_parent, match_parent);
        return new ForemRoot(activity, root);
    }

    void render(Root root);
}

