package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class Notification extends Activity {

    private NotificationCompat.Builder notification;
    private static final int uniqueID = 234567345;
    private static final String CHANNEL_ID = "420";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonClicked(View view) {
        Intent intent = new Intent(this, Notification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);

        // Build the notification
        notification = new NotificationCompat.Builder(this, CHANNEL_ID)
        // Delete the notification when the user comes back to this screen
        .setAutoCancel(true)
        .setSmallIcon(R.drawable.selected)
        .setTicker("This is the ticker.")
        .setWhen(System.currentTimeMillis())
        .setContentTitle("Here is the title.")
        .setContentText("I am the body text of your notification.")
        .setContentIntent(pendingIntent);

        createNotificationChannel();

        // Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}