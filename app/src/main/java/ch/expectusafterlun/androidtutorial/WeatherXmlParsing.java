package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WeatherXmlParsing extends AppCompatActivity implements View.OnClickListener {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/find?units=imperial&type=accurate&mode=xml&appid=0dcf84bfef65b293b5e3b444246ad6b2&lang=en&q=";
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
        String c = city.getText().toString();
        String s = state.getText().toString();
        StringBuilder url = new StringBuilder(BASE_URL);
        url.append(c).append(",").append(s);
        String fullURL = url.toString();
        try {
            URL website = new URL(fullURL);
            /* SAX = Simple API XML
             * Getting XMLReader to parse data
             */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            HandlingXMLStuff doingWork = new HandlingXMLStuff();
            xr.setContentHandler(doingWork);
            xr.parse(new InputSource(website.openStream()));

        } catch(Exception e) {
            tv.setText("error");
        }
    }
}