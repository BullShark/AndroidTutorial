package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BoundService extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_service);
    }

    public void showTime(View view) {

    }
}