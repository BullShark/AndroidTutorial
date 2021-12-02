package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class WidgetConfig extends Activity implements View.OnClickListener {

    private EditText info;
    private AppWidgetManager awm;
    private Context c;
    private int awID;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgetconfig);
        Button b = (Button) findViewById(R.id.b_widget_config);
        b.setOnClickListener(this);
        c = WidgetConfig.this;
        info = (EditText) findViewById(R.id.et_widget_config);
        // Getting info about the widget that launched this Activity
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras != null) {
            awID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            );
        }
    }
}
