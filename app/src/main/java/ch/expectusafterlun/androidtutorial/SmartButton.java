package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class SmartButton extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart);

        tv = findViewById(R.id.tv_bucky);
        Button button = findViewById(R.id.b_bucky);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tv.setText(R.string.timer_completed);
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                tv.setText(R.string.funny_message);
                //return true;
                return false;
            }
        });
    }
}