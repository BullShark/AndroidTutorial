package ch.expectusafterlun.androidtutorial;

import android.net.http.HttpResponseCache;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class HttpGetMethodEx {

    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;

        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI("http://www.mybringback.com");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


        } catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
