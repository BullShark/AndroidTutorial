package ch.expectusafterlun.androidtutorial;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class HttpGetMethodEx {

    public String getInternetData() throws Exception {
        BufferedReader in = null;
        StringBuilder sb = null;

        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI("http://www.mybringback.com");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            sb = new StringBuilder();
            String line;
            String newLine = System.getProperty("line.separator");

            while((line = in.readLine()) != null) {
                sb.append(line).append(newLine);
            }

        } catch(IOException e) {
            e.printStackTrace();

        } finally {

            if(in != null) {
                in.close();
            }

            return sb.toString();
        }
    }
}
