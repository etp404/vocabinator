package uk.co.mould.matt.vocabinator;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GlosbeVocabProvider implements VocabProvider {
    private ResponseGetter responseGetter;

    public GlosbeVocabProvider(ResponseGetter responseGetter) {
        this.responseGetter = responseGetter;
    }

    @Override
    public void getVocabItem(final String wordToBeTranslated, final VocabCallback vocabCallback) {
        responseGetter.getJsonForWord(new ResponseGetter.ResponseGetterCallback() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                GlosbeResponse glosbeResponse = gson.fromJson(result, GlosbeResponse.class);

                List<VocabItem> vocabItems = new ArrayList<>();
                for (TranslationItem translationItem : glosbeResponse.getTuc()) {
                    Phrase phrase = translationItem.getPhrase();
                    if (phrase.getLanguage().equals("en")) {
                        vocabItems.add(new VocabItem(phrase.getText(), wordToBeTranslated));
                    }
                }
                vocabCallback.success(vocabItems);
            }
        });

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
        private Meaning[] meanings;
        public Phrase getPhrase() {
            return phrase;
        }

        public void setPhrase(Phrase phrase) {
            this.phrase = phrase;
        }

        public Meaning[] getMeanings() {
            return meanings;
        }

        public void setMeanings(Meaning[] meanings) {
            this.meanings = meanings;
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

    private class Meaning {
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
