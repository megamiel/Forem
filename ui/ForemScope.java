<<<<<<< HEAD
public interface ForemScope {
    static void render(ViewGroup parent, View self, ForemNullarySetter fs){
        ViewGroup cacheParent=ForemFocusViewGroup.focusViewGroup;
        View cacheSelf=ForemFocusView.focusView;
        ForemFocusViewGroup.focusViewGroup=parent;
        ForemFocusView.focusView=self;
        fs.set();
        ForemFocusViewGroup.focusViewGroup=cacheParent;
        ForemFocusView.focusView=cacheSelf;
=======
// import文は省略しています


public interface ForemScope {
    static void render(ViewGroup parent, View self, ForemNullarySetter fs) {
        ViewGroup cacheParent = ForemFocusViewGroup.focusViewGroup;
        View cacheSelf = ForemFocusView.focusView;
        ForemFocusViewGroup.focusViewGroup = parent;
        ForemFocusView.focusView = self;
        fs.set();
        ForemFocusViewGroup.focusViewGroup = cacheParent;
        ForemFocusView.focusView = cacheSelf;
>>>>>>> e3b7e8e595d111803699e42b586d185538f17397
    }
}
