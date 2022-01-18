package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

public class StatusBar extends Activity implements View.OnClickListener {

    private NotificationManager nm;

    protected void onCreate(Bundle savedInstanceState) {
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
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        String body = "This is a message from Chris. Thanks for your support.";
        String title = "Chris L.";
        // depreciated
        //n.setLatestEventInfo(this, title, body, pi);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(StatusBar.this, getString(R.string.default_notification_channel_id));
        builder.setAutoCancel(false);
        builder.setTicker("This is a ticker text.");
        builder.setContentTitle(title);
        builder.setContentText(body);
        builder.setSmallIcon(R.drawable.gentoo);
        //builder.setLargeIcon(gentoobig);
        builder.setContentIntent(pi);
        builder.setOngoing(false);
        builder.setNumber(100);

        // depreciated
        //Notification n = builder.getNotification();
        nm.notify(Integer.parseInt(getString(R.string.default_notification_channel_id)), builder.build());

        // depreciated
        //Notification n = new Notification(R.drawable.gentoo, body, System.currentTimeMillis());

        /* Sound, vibrate, and more */
        //n.defaults = Notification.DEFAULT_ALL;
    }
}
