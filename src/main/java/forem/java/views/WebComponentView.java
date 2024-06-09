package forem.java.views;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

public class WebComponentView extends WebView {

    public WebComponentView(@NonNull Context context) {
        super(context);
        setWebViewClient(new WebViewClient());
        getSettings().setJavaScriptEnabled(true);
    }
}
