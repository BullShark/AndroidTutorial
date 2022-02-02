package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.Arrays;

public class Data extends Activity implements OnClickListener {

	private Button bStart, bStartFor;
	private EditText etSend;
	private TextView tvAnswer;
	private RelativeLayout rl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receive);
		initialize();

		// Create a banner ad. The ad size and ad unit ID must be set before calling loadAd.
		rl = (RelativeLayout) findViewById(R.id.rel_layout);
		AdView ad = new AdView(Data.this);
		// Create an ad request.
		AdRequest request = new AdRequest.Builder()
				//.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
				//.addTestDevice("17281JECB02717")  // My Google Pixel Phone
				.build();

		new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("13B6DBC07B8192BE1B8441B62BCCFAA2"));

		/*
		List<String> testDeviceIds = Arrays.asList("13B6DBC07B8192BE1B8441B62BCCFAA2");
		RequestConfiguration configuration =
				new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
		MobileAds.setRequestConfiguration(configuration);
		*/

		ad.setAdSize(AdSize.BANNER);
		ad.setAdUnitId(String.valueOf(R.string.banner_ad_unit_id_test));
		rl.addView(ad);
		ad.loadAd(request);

	}

	private void initialize() {
		etSend = (EditText) findViewById(R.id.et_send);
		bStart = (Button) findViewById(R.id.b_start_activity);
		bStartFor = (Button) findViewById(R.id.b_start_activity_for_result);
		tvAnswer = (TextView) findViewById(R.id.tv_received);

		// Set Listeners
		if(bStart == null) {
			Log.e("Data Button", "bStart is null!");
		} else {
			bStart.setOnClickListener(this);
		}

		if(bStartFor == null) {
			Log.e("Data Button", "bStartFor is null!");
		} else {
			bStartFor.setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.b_start_activity:
				String bread = etSend.getText().toString();
				Bundle basket = new Bundle();
				// Putting the bread in the basket
				basket.putString("key", bread);
				Intent a = new Intent(Data.this, Opens.class);
				a.putExtras(basket);
				startActivity(a);
				break;
			case R.id.b_start_activity_for_result:
				Intent i = new Intent(Data.this, Opens.class);
				startActivityForResult(i, 0); // 0 is the default
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			String str = basket.getString("answer");
			tvAnswer.setText(str);
		}
	}
}