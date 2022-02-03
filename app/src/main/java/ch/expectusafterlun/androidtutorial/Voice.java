package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

public class Voice extends Activity implements View.OnClickListener {

    private ListView lv;
    private static final int check = 1111;
    //private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice);
        lv = (ListView) findViewById(R.id.lv_voice_return);
        Button b = (Button) findViewById(R.id.b_voice);
        b.setOnClickListener(this);

        //ll = (LinearLayout) findViewById(R.id.linear_layout1);
        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("13B6DBC07B8192BE1B8441B62BCCFAA2")).build();
        MobileAds.setRequestConfiguration(configuration);

        mAdView.setAdUnitId(String.valueOf(R.string.banner_ad_unit_id_test));
        mAdView.setAdSize(AdSize.BANNER);
        //ll.addView(mAdView);
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        /* The below is required when the line above is there */
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak up son!");
        startActivityForResult(i, check);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == check && resultCode == RESULT_OK) {
            ArrayList<String> results = data != null ? data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) : null;
            lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results));
        }
    }
}