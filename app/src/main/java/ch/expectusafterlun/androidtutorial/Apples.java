package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Apples extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apples);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Bacon.class);

        final EditText et = findViewById(R.id.apples_input);
        String userMsg = et.getText().toString();
        i.putExtra("appleMessage", userMsg);

        startActivity(i);
    }
}