<<<<<<< HEAD
=======
// import文は省略しています

>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
public interface Forem extends ForemOrigin {
    default ForemRoot Root() {
        Activity activity = (Activity) this;
        Root root = new Root(activity);
        layoutView(root, match_parent, match_parent);
        return new ForemRoot(activity, root);
    }

    void render(Root root);
}

