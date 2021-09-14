package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Christopher Lemire
 */
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
    }
}