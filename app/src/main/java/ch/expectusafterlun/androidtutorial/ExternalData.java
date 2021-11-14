package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ExternalData extends AppCompatActivity {

    private TextView canWrite, canRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canWrite = (TextView)  findViewById(R.id.tvCanWrite);
        canRead = (TextView)  findViewById(R.id.tvCanRead);
    }
}