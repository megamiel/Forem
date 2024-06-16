package forem.java.activitys;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import forem.java.functionalInterfaces.ForemNullarySetter;
import forem.java.ui.Forem;

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
