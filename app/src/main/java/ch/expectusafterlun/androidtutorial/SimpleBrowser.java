package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends AppCompatActivity implements View.OnClickListener {

    EditText url;
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        browser = (WebView) findViewById(R.id.wv_browser);
        browser.getSettings().setJavaScriptEnabled(true);
        /* Load the page in overview (Zoomed out) mode */
        browser.getSettings().setLoadWithOverviewMode(true);
        /* Do not be confined to the browser's dimensions */
        browser.getSettings().setUseWideViewPort(true);
        browser.setWebViewClient(new ViewClient());
        try {
            browser.loadUrl("https://expectusafterlun.ch");
        } catch(Exception e) {
            e.printStackTrace();
        }

        Button go = (Button) findViewById(R.id.b_go);
        Button back = (Button) findViewById(R.id.b_back);
        Button refresh = (Button) findViewById(R.id.b_refresh);
        Button forward = (Button) findViewById(R.id.b_forward);
        Button clearHistory = (Button) findViewById(R.id.b_history);

        url = (EditText) findViewById(R.id.et_url);

        go.setOnClickListener(this);
        back.setOnClickListener(this);
        refresh.setOnClickListener(this);
        forward.setOnClickListener(this);
        clearHistory.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.b_go:
                String website = url.getText().toString();
                browser.loadUrl(website);
                /* Hide keyboard after using EditText */
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
                break;
            case R.id.b_back:
                if(browser.canGoBack()) {
                    browser.goBack();
                }
                break;
            case R.id.b_forward:
                if(browser.canGoForward()) {
                    browser.goForward();
                }
                break;
            case R.id.b_refresh:
                browser.reload();
                break;
            case R.id.b_history:
                browser.clearHistory();
                break;
        }
    }
}