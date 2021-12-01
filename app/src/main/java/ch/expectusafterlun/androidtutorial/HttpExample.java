package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.AsyncTask;
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
    private JSONObject json;
    /* Version 1 of the Twitter API is no longer available. OAUTH is now required in newer versions */
//    public final static String URL = "https://api.twitter.com/1/statuses/user_timeline.json?screen_name=";
    /* Get a random Urban Dictionary definition instead */
    public final static String URL = "https://api.urbandictionary.com/v0/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_example);

        httpTv = (TextView) findViewById(R.id.tv_http);
        client = new DefaultHttpClient();
        new Read().execute("text");

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

    public JSONObject lastWordDefinition(String jsonItem) throws ClientProtocolException, IOException, JSONException {
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
            JSONArray list = new JSONArray(data);
            return list.getJSONObject(0); // Index 0 is the last tweet
        } else {
            runOnUiThread(new Runnable() {
                public void run() {
                    final Toast toast = Toast.makeText(HttpExample.this, "error", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            return new JSONObject("Error: HTTP Status was not 200");
        }
    }

    public class Read extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                /* word, definition */
                json = lastWordDefinition("list");
                return json.getString(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            httpTv.setText(result);
        }
    }
}