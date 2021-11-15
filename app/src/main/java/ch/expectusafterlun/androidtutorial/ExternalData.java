package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalData extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView canWrite, canRead;
    private String state;
    private boolean canW, canR;
    private Spinner spinner;
    private final String[] PATHS = { "Music", "Pictures", "Download" };
    private File path = null;
    private File file = null;
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
        saveFile = (EditText) findViewById(R.id.etSaveAs);
        confirm.setOnClickListener((View.OnClickListener) this);
        save.setOnClickListener((View.OnClickListener) this);

        checkState();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, PATHS);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    private void checkState() {
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
                String f = saveFile.getText().toString() + ".png";
                file = new File(path, f);

                checkState();
                if(canW && canR) {

                    path.mkdirs();

                    try {
                        @SuppressLint("ResourceType")
                        InputStream is = getResources().openRawResource(R.drawable.greenball);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();

                        Toast t = Toast.makeText(ExternalData.this,
                                "File has been Saved!",
                                Toast.LENGTH_SHORT);
                        t.show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;
        }
    }
}