package uk.co.mould.matt.vocabinator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderResponseGetter implements uk.co.mould.matt.vocabinator.dictionaryapi.ResponseGetter {
    @Override
    public void getJsonForWord(String wordToBeTranslated, ResponseGetterCallback responseGetterCallback) {
        try {
            String response = "";
            String sampleFileName = String.format("sample_response_%s.json", wordToBeTranslated);
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(sampleFileName);
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
