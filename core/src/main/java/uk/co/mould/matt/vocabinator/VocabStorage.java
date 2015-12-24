package uk.co.mould.matt.vocabinator;

import java.util.Set;

public interface VocabStorage {
    void store(VocabItem vocabItem);

    Set<VocabItem> getVocabItems();
}
