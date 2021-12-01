package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherXmlParsing extends AppCompatActivity implements View.OnClickListener {

    private String url = "https://api.openweathermap.org/data/2.5/find?units=imperial&type=accurate&mode=xml&appid=0dcf84bfef65b293b5e3b444246ad6b2&lang=en&q=";
    private TextView tv;
    private EditText city, state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        Button b = (Button) findViewById(R.id.b_weather);
        tv = (TextView) findViewById(R.id.tv_weather);
        city = (EditText) findViewById(R.id.et_city);
        state = (EditText) findViewById(R.id.et_state);

        b.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {

    }
}