package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;

public class ExternalData extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView canWrite, canRead;
    private String state;
    private boolean canW, canR;
    private Spinner spinner;
    private final String[] PATHS = { "Music", "Pictures", "Download" };
    private File path = null;
    private EditText saveFile;
    private Button confirm, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canWrite = (TextView)  findViewById(R.id.tvCanWrite);
        canRead = (TextView)  findViewById(R.id.tvCanRead);
        state = Environment.getExternalStorageState();
        confirm = (Button) findViewById(R.id.bConfirmSaveAs);
        save = (Button) findViewById(R.id.bSaveFile);
        confirm.setOnClickListener((View.OnClickListener) this);
        save.setOnClickListener((View.OnClickListener) this);

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
                new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, PATHS);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // position
        int pos = spinner.getSelectedItemPosition();
        switch(pos) {
            case 0:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSaveFile:

                break;
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;
        }
    }
}