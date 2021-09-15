package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * Created by Christopher Lemire
 */
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabHost th = (TabHost) findViewById(R.id.tabhost);
        th.setup();
        TabSpec tabSpec = th.newTabSpec("tag1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("StopWatch");
        th.addTab(tabSpec);

        tabSpec = th.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Tab 2");
        th.addTab(tabSpec);

        tabSpec = th.newTabSpec("tag3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Add a Tab");
        th.addTab(tabSpec);
    }
}