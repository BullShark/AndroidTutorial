package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InternalData extends Activity implements View.OnClickListener {

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
        Button save = findViewById(R.id.bSave);
        Button load = findViewById(R.id.bLoad);
        dataResult = findViewById(R.id.tvLoadSharedPreferences);
        sharedData = findViewById(R.id.etSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
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
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(data.getBytes(StandardCharsets.UTF_8));
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bLoad:
                new LoadData().execute(FILENAME);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
    public class LoadData extends AsyncTask<String, Integer, String> {

        ProgressDialog dialog;

        /* Gets called first */
        protected void onPreExecute(String f) {
            // Example of setting up something
            dialog = new ProgressDialog(InternalData.this);
            dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder collected = new StringBuilder();
            FileInputStream fis = null;

            for(int i=0; i<20; i++) {
                publishProgress(5);
                try {
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dialog.dismiss();

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
                } finally {
                    return collected.toString();
                }
            }
        }

        protected void onProgressUpdate(Integer... progress) {
            dialog.incrementProgressBy(progress[0]);
        }

        protected void onPostExecute(String result) {
            dataResult.setText(result);
        }
    }
}