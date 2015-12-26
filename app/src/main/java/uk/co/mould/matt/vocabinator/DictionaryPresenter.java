package uk.co.mould.matt.vocabinator;

class DictionaryPresenter {
    public DictionaryPresenter(DictionaryView dictionaryView, VocabStorage fakeVocabStorage) {
        dictionaryView.show(fakeVocabStorage.getVocabItems());
    }
}
