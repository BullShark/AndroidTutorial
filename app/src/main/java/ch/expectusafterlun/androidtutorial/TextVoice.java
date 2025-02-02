package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Random;

public class TextVoice extends Activity implements View.OnClickListener {

    private static final String[] texts = {
        "What's up Gangstas!", "You smell!", "Supersize it!"
    };
    private TextToSpeech tts;

    protected void OnCreate(Bundle savedInstanceState) {
        Button b = findViewById(R.id.b_text_to_voice);
        b.setOnClickListener(this);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textvoice);
    }

    protected void onPause() {
        super.onPause();
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }

    @Override
    public void onClick(View v) {
        Random r = new Random();
        String random = texts[r.nextInt(3)];
        tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
    }
}
