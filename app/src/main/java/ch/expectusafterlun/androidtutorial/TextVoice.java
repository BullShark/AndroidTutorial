package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

public class TextVoice extends Activity implements View.OnClickListener {

    private static final String[] texts = {
        "Whaaat's up Gangstas!", "You smell!", "Supersize it!"
    };
    private TextToSpeech tts;

    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textvoice);
        Button b = (Button) findViewById(R.id.b_text_to_voice);
        b.setOnClickListener(this);
        tts = new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener() {
            public void onInit(int arg0) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
