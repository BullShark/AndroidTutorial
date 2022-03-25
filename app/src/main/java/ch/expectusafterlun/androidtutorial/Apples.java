package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Apples extends Activity {

    @Override
    /*
     * Whenever this activity gets created,
     * It's going to kick off the service.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apples);
        Intent intent = new Intent(this, ChrisIntentService.class);
        startService(intent);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Bacon.class);

        final EditText et = findViewById(R.id.apples_input);
        String userMsg = et.getText().toString();
        i.putExtra("appleMessage", userMsg);

        startActivity(i);
    }
}