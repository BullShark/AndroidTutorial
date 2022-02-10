package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class Allison extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        RelativeLayout rl = new RelativeLayout(this);
        Button redButton = new Button(this);
        EditText etUserName = new EditText(this);

        // Rules
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0, 50);

        // Attributes
        redButton.setId(1);
        etUserName.setId(2);
        redButton.setText("Log In");
        rl.setBackgroundColor(Color.GREEN);
        redButton.setBackgroundColor(Color.RED);

        // Add widget to layout
        rl.addView(redButton, buttonDetails);
        rl.addView(etUserName, userNameDetails);

        // Set this Activities content(display) to this View
        setContentView(rl);
    }
}