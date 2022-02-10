package ch.expectusafterlun.androidtutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//public class Random extends ActionBarActivity {
public class Random extends AppCompatActivity {

    private TextView tv;
    private ActionBar ab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);
        tv = (TextView) findViewById(R.id.tv1);
        tv.setTextColor(Color.WHITE);
        ab = getSupportActionBar();
        ab.setTitle("BlackHats");
    }
}
