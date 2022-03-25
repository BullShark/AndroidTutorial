package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bacon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacon);

        Bundle applesData = getIntent().getExtras();
        if(applesData == null) {
            return;
        }

        String appleMsg = applesData.getString("appleMessage");
        final TextView baconText = findViewById(R.id.bacon_text);
        baconText.setText(appleMsg);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Apples.class);

        startActivity(i);
    }
}