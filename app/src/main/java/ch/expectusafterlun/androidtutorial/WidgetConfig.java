package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;

public class WidgetConfig extends Activity implements View.OnClickListener {

    private EditText info;
    private AppWidgetManager awm;
    private Context c;
    private int awID;

    @Override
    public void onClick(View v) {
        String e = info.getText().toString();
        RemoteViews views = new RemoteViews(c.getPackageName(), R.layout.widget);
        views.setTextViewText(R.id.tv_config_input, e);
        Intent in = new Intent(c, Splash.class);
        PendingIntent pi = PendingIntent.getActivity(c, 0, in, 0);
        views.setOnClickPendingIntent(R.id.b_widget_open, pi);
        awm.updateAppWidget(awID, views);
        Intent result = new Intent();
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, awID);
        setResult(RESULT_OK, result);
        finish();
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
        } else {
            finish();
        }
        awm = AppWidgetManager.getInstance(c);
    }
}
