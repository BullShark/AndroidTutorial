package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClass extends Activity {

	private TextView tvQuestion, tvText;
	private RadioGroup rgAnswers;
	private RadioButton rCrazy, rAnnoying, rBoth;
	private Button bReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.send);
//		initialize();
	}

	private void initialize() {
		tvQuestion = (TextView) findViewById(R.id.tv_question);
		rgAnswers = (RadioGroup) findViewById(R.id.rg_answers);
		rCrazy = (RadioButton) findViewById(R.id.r_crazy);
		rAnnoying = (RadioButton) findViewById(R.id.r_annoying);
		rBoth = (RadioButton) findViewById(R.id.r_both);
		//TODO Why can't b_return be found?
		bReturn = (Button) findViewById(R.id.b_return);
		tvText = (TextView) findViewById(R.id.tv_text);
	}
}