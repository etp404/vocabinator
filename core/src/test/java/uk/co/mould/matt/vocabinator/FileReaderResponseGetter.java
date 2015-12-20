package uk.co.mould.matt.vocabinator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderResponseGetter implements ResponseGetter {
    @Override
    public void getJsonForWord(ResponseGetterCallback responseGetterCallback) {
        try {
            String response = "";
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("sample_response.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                response+=tmp;
            }
            resourceAsStream.close();
            responseGetterCallback.success(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
