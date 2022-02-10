package ch.expectusafterlun.androidtutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityState extends AppCompatActivity {

    private TextView tv;
    private ActionBar ab;
    private static final String TAG = "BlackHats";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state);
        tv = (TextView) findViewById(R.id.tv1);
        tv.setTextColor(Color.WHITE);
        ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("BlackHats");
        }

        Toast toast = Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(TAG, "onCreate called!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(TAG, "onDestroy called!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(this, "onStop called", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(TAG, "onStop called!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume called", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause called", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause called!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart called", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart called!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart called", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart called!");
    }
}
