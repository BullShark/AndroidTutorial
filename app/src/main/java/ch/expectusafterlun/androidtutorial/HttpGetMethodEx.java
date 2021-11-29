package ch.expectusafterlun.androidtutorial;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpGetMethodEx {

    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;

        try {
            HttpClient client = new DefaultHttpClient();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
