package ch.expectusafterlun.androidtutorial;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class ChrisIntentService extends IntentService {

    private static final String TAG = "ch.expectusafterlun.androidtutorial";

    public ChrisIntentService() {
        super("ChrisIntentService");
    }

    /*
     * This is what the service does
     */
    @SuppressLint("LongLogTag")
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "The service has now started.");
    }
}
