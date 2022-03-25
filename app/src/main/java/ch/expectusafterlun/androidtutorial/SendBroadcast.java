package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class SendBroadcast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_broadcast);
    }

    public void sendOutBroadcast(View view) {
        Intent i = new Intent();
        // We only want to listen for these intents/broadcast
        i.setAction("ch.expectusafterlun.androidtutorial");
        // Make this compatible with all versions of Android
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);
    }
}