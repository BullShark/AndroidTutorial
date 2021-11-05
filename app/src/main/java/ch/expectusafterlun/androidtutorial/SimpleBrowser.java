package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        browser.setWebViewClient(new ViewClient());
        browser.loadUrl("https://expectusafterlun.ch");

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