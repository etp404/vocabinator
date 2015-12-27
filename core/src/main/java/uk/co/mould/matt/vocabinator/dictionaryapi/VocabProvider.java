package uk.co.mould.matt.vocabinator.dictionaryapi;

import java.util.List;

import uk.co.mould.matt.vocabinator.VocabItem;

public interface VocabProvider {
    void getVocabItem(String someWord, VocabCallback callback);

    interface VocabCallback {
        void success(List<VocabItem> vocabItems);
    }
}
