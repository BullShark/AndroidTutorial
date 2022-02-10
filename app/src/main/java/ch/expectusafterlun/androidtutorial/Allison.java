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

        // Rules
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        // Attributes
        redButton.setText("Push me!");
        rl.setBackgroundColor(Color.GREEN);
        redButton.setBackgroundColor(Color.RED);

        // Add widget to layout
        rl.addView(redButton, buttonDetails);

        // Set this Activities content(display) to this View
        setContentView(rl);
    }
}