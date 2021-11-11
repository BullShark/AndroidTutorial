package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class Flipper extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        flipper.setOnClickListener(this);
        flipper.setFlipInterval(500);
        flipper.startFlipping();
    }

    @Override
    public void onClick(View view) {
        flipper.showNext();
    }
}