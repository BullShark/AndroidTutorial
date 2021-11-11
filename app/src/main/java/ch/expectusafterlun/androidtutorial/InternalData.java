package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalData extends AppCompatActivity implements View.OnClickListener {

    private EditText sharedData;
    private TextView dataResult;
    public static final String FILENAME = "Internal";

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
        SharedPreferences prefs = getSharedPreferences(FILENAME, 0);
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSave:

                break;
            case R.id.bLoad:

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}