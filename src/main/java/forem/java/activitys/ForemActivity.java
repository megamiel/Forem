package forem.java.activitys;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.ui.Forem;
import forem.java.ui.ForemFocusViewGroup;
import forem.java.ui.ForemOrigin;
import forem.java.ui.ForemUnaryComponent;

public abstract class ForemActivity extends AppCompatActivity implements Forem {
    protected final ForemActivity $ = this;

    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        activity[0] = $;
        Root().render(this::render);
        getOnBackPressedDispatcher().addCallback(onBackPressedCallback);
    }

    public static final ForemNullarySetter none = () -> {
    };
    public ForemNullarySetter onBack = this::finish;
    OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            onBack.set();
        }
    };
}
