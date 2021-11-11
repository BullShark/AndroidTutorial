package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends AppCompatActivity {

    private EditText sharedData;
    private TextView dataResult;
    public static final String FILENAME = "SHARED";
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setupVariables();
    }

    private void setupVariables() {
        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.etSharedPrefs);
        save.setOnClickListener((View.OnClickListener) this);
        load.setOnClickListener((View.OnClickListener) this);
        prefs = getSharedPreferences(FILENAME, 0);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSave:
                String data = sharedData.getText().toString();
                break;
            case R.id.bLoad:

                break;
        }
    }
}