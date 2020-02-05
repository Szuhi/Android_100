package com.tamasszuhanszky.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    // We are going to use different threads for running our tasks, just because we don't want to delay the run of the app itself while we are downloading
    public class DownloadTask extends AsyncTask<String, Void, String> {

        // String... is kinda like an array, new syntax to JAVA
        @Override
        protected String doInBackground(String... urls) {
            Log.i("URL", urls[0]);

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();            // Just a string to hold the input of data as it comes in
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                // While loop for reading data
                while (data != -1) {
                    char current = (char)data;
                    result += current;
                    data = reader.read();                                   // Data to move on to the next character
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();

                return "Failed";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String result = null;
        try {
            result = task.execute("https://www.ecowebhosting.co.uk/").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i("Contents of URL", result);
    }
}
