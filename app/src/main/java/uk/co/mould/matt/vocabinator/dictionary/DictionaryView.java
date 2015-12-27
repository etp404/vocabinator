package uk.co.mould.matt.vocabinator.dictionary;

import java.util.List;

import uk.co.mould.matt.vocabinator.VocabItem;

public interface DictionaryView {
    void show(List<VocabItem> vocabItems);
}
