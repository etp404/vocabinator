package uk.co.mould.matt.vocabinator;

import com.google.gson.Gson;

public class GlosbeVocabProvider implements VocabProvider {
    private ResponseGetter responseGetter;

    public GlosbeVocabProvider(ResponseGetter responseGetter) {

        this.responseGetter = responseGetter;
    }

    @Override
    public String getVocabItem(String some_word) {
        String response = responseGetter.getJsonForWord();
        response = response.replace(" ", "");
        Gson gson = new Gson();
        GlosbeResponse glosbeResponse = gson.fromJson(response, GlosbeResponse.class);
        return glosbeResponse.getTuc()[0].getPhrase().getText();
    }

    private class GlosbeResponse {
        public TranslationItem[] getTuc() {
            return tuc;
        }

        public void setTuc(TranslationItem[] tuc) {
            this.tuc = tuc;
        }

        TranslationItem[] tuc;

    }

    private class TranslationItem {
        private Phrase phrase;

        public Phrase getPhrase() {
            return phrase;
        }

        public void setPhrase(Phrase phrase) {
            this.phrase = phrase;
        }
    }

    private class Phrase {
        private String text;
        private String language;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
