package uk.co.mould.matt.vocabinator;

public interface ResponseGetter {
    void getJsonForWord(String wordToBeTranslated, ResponseGetterCallback responseGetterCallback);
    interface ResponseGetterCallback {
        void success(String result);
    }
}

