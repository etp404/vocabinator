package uk.co.mould.matt.vocabinator;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

class HttpResponseGetter implements ResponseGetter {
    @Override
    public void getJsonForWord(final ResponseGetterCallback responseGetterCallback) {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                String result = "";

                URL url = null;
                try {
                    url = new URL("https://glosbe.com/gapi/translate?from=fra&dest=eng&format=json&phrase=ainsi");
                    String line;
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = rd.readLine()) != null) {
                        result += line;
                    }
                    rd.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                responseGetterCallback.success(result);
                return null;
            }
        };
        asyncTask.execute();
    }

}
