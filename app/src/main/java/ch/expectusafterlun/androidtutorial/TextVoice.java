package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;
import java.util.Random;

public class TextVoice extends Activity implements View.OnClickListener {

    private static final String[] texts = {
        "Whaaat's up Gangstas!", "You smell!", "Supersize it!"
    };
    private TextToSpeech tts;
    private AppCompatButton b;

    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textvoice);
        b = (AppCompatButton) findViewById(R.id.b_text_to_voice);
        b.setOnClickListener(this);
        tts = new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener() {
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
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
