package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
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
        HttpResponse response = client.execute(get);
        /* Status Codes:
         * 1xx - Informational
         * 2xx - Success
         * 3xx - Redirection
         * 4xx - Client Error
         * 5xx - Server Error
         */
        int status = response.getStatusLine().getStatusCode();

        if(status == 200) {
            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity);
            JSONArray timeline = new JSONArray(data);
            JSONObject last = timeline.getJSONObject(0);
            return last;
        } else {
            Toast.makeText(HttpExample.this, "error", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}