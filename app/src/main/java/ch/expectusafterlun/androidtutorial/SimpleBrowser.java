package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class SimpleBrowser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        WebView browser = (WebView) findViewById(R.id.wv_browser);
        browser.loadUrl("https://expectusafterlun.ch");
    }
}