package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Count extends Activity {

	private static int counter = 0;
	private TextView display;
	private String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);
		Button add = findViewById(R.id.b_add);
		Button sub = findViewById(R.id.b_sub);
		display = findViewById(R.id.tv_display);

        total = "Your total is ";
        display.setText(total + counter);
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				display.setText(total + ++counter);
			}
		});
        sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				display.setText(total + --counter);
			}
		});
    }
}
