package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.Button;

import android.os.Bundle;

public class Allison extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        RelativeLayout rl = new RelativeLayout(this);
        Button redButton = new Button(this);

        // Attributes
        redButton.setText("Push me!");
        redButton.setBackgroundColor(Color.RED);

        // Add widget to layout
        rl.addView(redButton);

        // Set this Activities content(display) to this View
        setContentView(rl);
    }
}