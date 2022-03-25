package ch.expectusafterlun.androidtutorial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ch.expectusafterlun.androidtutorial.TimeService.MyLocalBinder;

public class BoundService extends Activity {

    private TimeService service;
    private boolean isBound = false;
    private static final String TAG = "ch.expectusafterlun.androidtutorial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_service);
        Intent i = new Intent(this, TimeService.class);
        bindService(i, sConn, Context.BIND_AUTO_CREATE);
    }

    @SuppressLint("LongLogTag")
    public void showTime(View view) {
        String currentTime = service.getCurrentTime();
        Log.i(TAG, "The currentTime is: " + currentTime);
        TextView tv = findViewById(R.id.buckys_text3);
        tv.setText(currentTime);
    }

    private ServiceConnection sConn = new ServiceConnection() {
        /*
         * What do you want to happen when you try to connect?
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            BoundService.this.service = binder.getService();
            isBound = true;
        }

        /*
         * What do you want to happen when you try to disconnect?
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}