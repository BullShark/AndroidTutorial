package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	private Button bStart, bStartFor;
	private EditText etSend;
	private TextView tvAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receive);
		initialize();
	}

	private void initialize() {
		etSend = (EditText) findViewById(R.id.et_send);
		bStart = (Button) findViewById(R.id.b_sa);
		bStartFor = (Button) findViewById(R.id.b_safr);
		tvAnswer = (TextView) findViewById(R.id.tv_received);
		// Set Listeners
		bStart.setOnClickListener(this);
		bStartFor.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}