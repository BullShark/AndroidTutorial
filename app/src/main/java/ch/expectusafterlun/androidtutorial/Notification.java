package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.core.app.NotificationCompat;

public class Notification extends Activity {

    private NotificationCompat.Builder notification;
    private static final int uniqueID = 234567345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        notification = new NotificationCompat.Builder(this);
        // Delete the notification when the user comes back to this screen
        notification.setAutoCancel(true);
    }

    public void buttonClicked(View view) {
    }
}