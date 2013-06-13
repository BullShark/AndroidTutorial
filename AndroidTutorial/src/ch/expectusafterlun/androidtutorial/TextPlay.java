package ch.expectusafterlun.androidtutorial;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {

	Button chkCmd;
	ToggleButton passTog;
	EditText input;
	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
				
		baconAndEggs();
		
		/*
		 * Could use passTog.setChecked() instead
		 * But onClickListener is needed for later tutorials 
		 */
		passTog.setOnClickListener(this);
		chkCmd.setOnClickListener(this);
	}
	/*
	 * This is created in the tutorial video #33
	 * Just to show how to create a method
	 */
	private void baconAndEggs() {
		chkCmd = (Button) findViewById(R.id.b_results);
		passTog = (ToggleButton) findViewById(R.id.tb_pass);
		input = (EditText) findViewById(R.id.et_commands);
		display = (TextView) findViewById(R.id.tv_results);
	}
	@SuppressLint("DefaultLocale")
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()) {
		case R.id.b_results:
			String check = input.getText().toString();
			display.setText(check);
			if(check.contentEquals("left")) {
				display.setGravity(Gravity.LEFT);
			} else if(check.contentEquals("center")) {
				display.setGravity(Gravity.CENTER);
			} else if(check.contentEquals("right")) {
				display.setGravity(Gravity.RIGHT);
			} else if(check.contentEquals("blue")) {
				display.setTextColor(Color.BLUE);
			} else if (check.toLowerCase().contains("wtf")) {
				Random crazy = new Random();
				display.setText("Where's the Fridge???");
				int max = 47;
				// Should be [1, max]
				display.setTextSize(crazy.nextInt(max) + 1);
				//display.setTextSize(max);

				display.setTextColor(
						Color.rgb(crazy.nextInt(256), crazy.nextInt(256), crazy.nextInt(256)));
				switch(crazy.nextInt(3)) {
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.CENTER);
					break;
				case 2:
					display.setGravity(Gravity.RIGHT);
					break;
				}
			} else {
				display.setText("Use one: left, center, right, blue, WTF");
				display.setGravity(Gravity.CENTER);
				System.out.println("Text Size: " + display.getTextSize());
				display.setTextSize(21);
			}
			break;
		case R.id.tb_pass:
			// Is the ToggleButton checked on
			if(passTog.isChecked()) {
				//TODO What is the | (pipe) ,and why is it needed?
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				
				//FIXME Does not work, why not?
				//input.setInputType(InputType.TYPE_CLASS_TEXT);
				System.out.println("on toggle");
			} else {
				input.setInputType(InputType.TYPE_CLASS_TEXT);
				
				//FIXME Does not work, why?
				//input.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
				System.out.println("off toggle");	
			}
			break;
		}
	}
}