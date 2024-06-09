package forem.java.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import forem.java.ui.Forem;

public abstract class ForemActivity extends AppCompatActivity implements Forem {
    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Root().render(this::render);
    }
}
