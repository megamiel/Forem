package com.example.wantouch_project.forem.ui;

import android.view.View;
import android.view.ViewGroup;

import com.example.wantouch_project.forem.functionalInterfaces.ForemNullarySetter;


public interface ForemScope {
    static void render(ViewGroup parent, View self, ForemNullarySetter fs){
        ViewGroup cacheParent=ForemFocusViewGroup.focusViewGroup;
        View cacheSelf=ForemFocusView.focusView;
        ForemFocusViewGroup.focusViewGroup=parent;
        ForemFocusView.focusView=self;
        fs.set();
        ForemFocusViewGroup.focusViewGroup=cacheParent;
        ForemFocusView.focusView=cacheSelf;
    }
}
