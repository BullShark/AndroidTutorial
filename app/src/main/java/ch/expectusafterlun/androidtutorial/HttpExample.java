package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HttpExample extends Activity {

    private TextView httpTv;
    private HttpClient client;

    public final static String URL = "http://api.twitter.com/1/statuses/user_timeline.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_example);

        httpTv = (TextView) findViewById(R.id.tv_http);
        client = new DefaultHttpClient();

        /*
        HttpGetMethodEx test = new HttpGetMethodEx();
        String returned = null;
        try {
            returned = test.getInternetData();
            httpTv.setText(returned);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public JSONObject lastTweet(String username) throws ClientProtocolException, IOException, JSONException {
        StringBuilder url = new StringBuilder(URL);

        HttpGet get = new HttpGet(url.toString());

        return null;
    }
}