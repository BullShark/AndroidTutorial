package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ExternalData extends AppCompatActivity {

    private TextView canWrite, canRead;
    private String state;
    private boolean canW, canR;
    private Spinner spinner;
    private String[] paths = { "Music", "Pictures", "Download" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canWrite = (TextView)  findViewById(R.id.tvCanWrite);
        canRead = (TextView)  findViewById(R.id.tvCanRead);
        state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)) {
            // Read and write
            canWrite.setText("Can write: true");
            canRead.setText("Can reads: true");
            canW = canR = true;
        } else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Read but can't write
            canWrite.setText("Can write: false");
            canRead.setText("Can reads: true");
            canW = false;
            canR = true;
        } else {
            canWrite.setText("Can write: false");
            canRead.setText("Can reads: false");
            canW = canR = false;
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }
}