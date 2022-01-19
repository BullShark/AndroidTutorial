package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WeatherXmlParsing extends Activity implements View.OnClickListener {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/find?units=imperial&type=accurate&mode=xml&appid=0dcf84bfef65b293b5e3b444246ad6b2&lang=en&q=";
    private TextView tv;
    private EditText city, state;
    private XMLReader xr;
    private URL website;

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
        try {
            if(!c.equals("") && !s.equals("")) {
                url.append(c).append(",").append(s);
            } else if(!c.equals("")) {
                url.append(c);
            } else {
                throw new Exception("Couldn't get city and state");
            }
            String fullURL = url.toString();
            website = new URL(fullURL);

            /* SAX = Simple API XML
             * Getting XMLReader to parse data
             */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            xr = sp.getXMLReader();

            /* Move the networking off the main thread */
            new MyTask().execute();

        /* More information on what went wrong */
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            tv.setText("Error: ParserConfigurationException");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            tv.setText("Error: MalformedURLException");
        } catch (IOException e) {
            e.printStackTrace();
            tv.setText("Error: IOException");
        } catch (SAXException e) {
            e.printStackTrace();
            tv.setText("Error: SAXException");
        } catch (Exception e) {
            e.printStackTrace();
            tv.setText("Error: Exception\nCity: " + c + "\nState: " + s);
        }
    }

    public class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {

            HandlingXMLStuff doingWork = new HandlingXMLStuff();
            xr.setContentHandler(doingWork);
            try {
                xr.parse(new InputSource(website.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return doingWork.getInformation();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}