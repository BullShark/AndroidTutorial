package ch.expectusafterlun.androidtutorial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InternalData extends AppCompatActivity implements View.OnClickListener {

    private EditText sharedData;
    private TextView dataResult;
    public static final String FILENAME = "Internal";
    private FileOutputStream fos;

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
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSave:
                String data = sharedData.getText().toString();
/*
                File f = new File(FILENAME);
                try {
                    fos = new FileOutputStream(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
 */
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(data.getBytes(StandardCharsets.UTF_8));
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bLoad:
                StringBuilder collected = new StringBuilder();
                FileInputStream fis = null;
                try {
                    fis = openFileInput(FILENAME);
                    byte[] databytes = new byte[fis.available()];
                    while(fis.read(databytes) != -1) {
                        collected.append(new String(databytes));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                        dataResult.setText(collected);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}