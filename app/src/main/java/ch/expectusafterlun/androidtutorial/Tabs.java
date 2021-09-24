package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

/**
 * Created by Christopher Lemire
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView showResults;
    long start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        th = (TabHost) findViewById(R.id.tabhost);
        th.setup();
        Button newTab = (Button) findViewById(R.id.btn_add_tab);
        Button btnStart = (Button) findViewById(R.id.btn_start_watch);
        Button btnStop = (Button) findViewById(R.id.btn_stop_watch);
        showResults = (TextView) findViewById(R.id.tv1);

        newTab.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

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

        start = 0;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_add_tab:

                TabSpec tabSpec = th.newTabSpec("tag1");
                tabSpec.setContent(new TabHost.TabContentFactory() {

                    public View createTabContent(String tag) {

                        TextView tv = new TextView(Tabs.this);
                        tv.setText("You've created a new Tab!");
                        return tv;
                    }
                });
                tabSpec.setIndicator("New");
                th.addTab(tabSpec);

                break;

            case R.id.btn_start_watch:
                start = System.currentTimeMillis();
                break;

            case R.id.btn_stop_watch:
                stop = System.currentTimeMillis();

                if(start != 0) {
                    long result = stop - start;
                    showResults.setText(Long.toString(result));
                }
                break;
        }
    }
}