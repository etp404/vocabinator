package uk.co.mould.matt.vocabinator;

import java.util.List;

public interface VocabStorage {
    void store(VocabItem vocabItem);
    List<VocabItem> getVocabItems();
}
