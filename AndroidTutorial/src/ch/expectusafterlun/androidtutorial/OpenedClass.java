package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	private TextView tvQuestion, tvText;
	private RadioGroup rgAnswers;
	private RadioButton rCrazy, rAnnoying, rBoth;
	private Button bReturn;
	private String gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		/*
		 * Prevents the app from crashing
		 * If a bundle with extras was not created
		 * When calling this activity through intent
		 * startActivityForResult button
		 */
		try {
			Bundle gotBasket = getIntent().getExtras();
			String gotBread = gotBasket.getString("key");
			tvQuestion.setText(gotBread);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		tvQuestion = (TextView) findViewById(R.id.tv_question);
		rgAnswers = (RadioGroup) findViewById(R.id.rg_answers);
		rCrazy = (RadioButton) findViewById(R.id.r_crazy);
		rAnnoying = (RadioButton) findViewById(R.id.r_annoying);
		rBoth = (RadioButton) findViewById(R.id.r_both);
		bReturn = (Button) findViewById(R.id.b_return);
		tvText = (TextView) findViewById(R.id.tv_text);

		bReturn.setOnClickListener(this);
		rgAnswers.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		// person means a person can carry stuff between two activities
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		// Gives result back sense this Activity was started for result
		setResult(RESULT_OK, person);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.r_crazy:
			setData = "Probably right!";
			break;
		case R.id.r_annoying:
			setData = "Definitely right!";
			break;
		case R.id.r_both:
			setData = "Spot on!";
			break;
		}
		tvText.setText(setData);
	}
}