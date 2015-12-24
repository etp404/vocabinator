package uk.co.mould.matt.vocabinator;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesVocabStorage implements VocabStorage {

    private final List<VocabItem> internalList;

    public SharedPreferencesVocabStorage() {
        internalList = new ArrayList<>();
    }

    @Override
    public void store(VocabItem vocabItem) {
        internalList.add(vocabItem);
    }

    @Override
    public List<VocabItem> getVocabItems() {
        return internalList;
    }
}
