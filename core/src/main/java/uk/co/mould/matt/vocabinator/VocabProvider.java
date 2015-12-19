package uk.co.mould.matt.vocabinator;

import java.util.List;

public interface VocabProvider {
    String getVocabItem(String someWord, VocabCallback callback);

    interface VocabCallback {
        void success(List<VocabItem> vocabItems);
    }
}
