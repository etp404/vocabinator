package uk.co.mould.matt.vocabinator.dictionary;

import uk.co.mould.matt.vocabinator.VocabStorage;

public class DictionaryPresenter {
    public DictionaryPresenter(DictionaryView dictionaryView, VocabStorage vocabStorage) {
        dictionaryView.show(vocabStorage.getVocabItems());
    }
}
