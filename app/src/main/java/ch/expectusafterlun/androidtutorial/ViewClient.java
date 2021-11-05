package ch.expectusafterlun.androidtutorial;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView wv, String url) {
        wv.loadUrl(url);
        return true;
    }
}
