package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class SmartButton extends AppCompatActivity {

    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart);

        tv = (TextView) findViewById(R.id.tv_bucky);
        button = (Button) findViewById(R.id.b_bucky);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tv.setText("Good job Hoss!");
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                tv.setText("Holy carp, that was a long one!");
                //return true;
                return false;
            }
        });
    }
}