package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class StatusBar extends Activity implements View.OnClickListener {

    private NotificationManager nm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statusbar);
        Button stat = (Button) findViewById(R.id.b_statusbar);
        stat.setOnClickListener(this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        super.onCreate(new Bundle());
        Intent intent = new Intent(this, StatusBar.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
    }
}
