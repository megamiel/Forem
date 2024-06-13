package forem.java.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import forem.java.ui.Forem;
import forem.java.ui.ForemFocusViewGroup;

public abstract class ForemActivity extends AppCompatActivity implements Forem {
    protected final ForemActivity $=this;
    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Root().render(this::render);
    }
}
