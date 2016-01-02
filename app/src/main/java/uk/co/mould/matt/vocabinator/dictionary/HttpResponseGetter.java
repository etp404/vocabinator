package uk.co.mould.matt.vocabinator.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

class HttpResponseGetter implements uk.co.mould.matt.vocabinator.dictionaryapi.ResponseGetter {
    @Override
    public void getJsonForWord(final String wordToBeTranslated, final ResponseGetterCallback responseGetterCallback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = "";

                URL url = null;
                try {
                    url = new URL(String.format("https://glosbe.com/gapi/translate?from=fra&dest=eng&format=json&phrase=%s", wordToBeTranslated));
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
            }
        });
        thread.start();
    }

}
