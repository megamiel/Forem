package com.example.wantouch_project.forem.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.wantouch_project.forem.ui.Forem;

public abstract class ForemActivity extends AppCompatActivity implements Forem {
    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Root().render(this::render);
    }
}
