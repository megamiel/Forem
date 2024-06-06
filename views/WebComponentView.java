public class WebComponentView extends WebView {

    public WebComponentView(@NonNull Context context) {
        super(context);
        setWebViewClient(new WebViewClient());
        getSettings().setJavaScriptEnabled(true);
        loadUrl("https://megamiel.github.io/dotcom");
    }
}
