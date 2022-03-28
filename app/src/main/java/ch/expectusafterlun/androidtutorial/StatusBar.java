package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.NotificationChannel;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class StatusBar extends Activity implements View.OnClickListener {

    private NotificationManager nm;
    private int CHANNEL_ID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statusbar);
        Button stat = (Button) findViewById(R.id.b_statusbar);
        stat.setOnClickListener(this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        CHANNEL_ID = Integer.parseInt(getString(R.string.default_notification_channel_id));
        nm.cancel(CHANNEL_ID);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        super.onCreate(null);
        Intent intent = new Intent(this, StatusBar.class);
        PendingIntent pi = PendingIntent.getActivity(this, 420, intent, PendingIntent.FLAG_IMMUTABLE);
        String body = "This is a message from Chris. Thanks for your support.";
        String title = "Chris L.";
        Resources res = getApplicationContext().getResources();
        // depreciated
        //n.setLatestEventInfo(this, title, body, pi);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(StatusBar.this, getString(R.string.default_notification_channel_id));
        builder.setAutoCancel(false);
        builder.setTicker("This is a ticker text.");
        builder.setContentTitle(title);
        builder.setContentText(body);
        builder.setSmallIcon(R.drawable.gentoo);
        builder.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.gentoo));
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pi);
        builder.setOngoing(true);
        builder.setNumber(100);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        createNotificationChannel();

        // depreciated
        //Notification n = builder.getNotification();

        Notification n = builder.build();
        n.defaults = Notification.DEFAULT_ALL;
        nm.notify(Integer.parseInt(getString(R.string.default_notification_channel_id)), n);
        finish(); // Prevent duplicates of the same Activity

        // depreciated
        //Notification n = new Notification(R.drawable.gentoo, body, System.currentTimeMillis());

        /* Sound, vibrate, and more */
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(String.valueOf(CHANNEL_ID), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
