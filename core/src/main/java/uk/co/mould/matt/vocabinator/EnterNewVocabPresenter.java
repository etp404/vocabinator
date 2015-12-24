package uk.co.mould.matt.vocabinator;

public class EnterNewVocabPresenter {

    public EnterNewVocabPresenter(final EnterNewVocabView enterNewVocabView, final VocabStorage vocabStorage) {
        enterNewVocabView.attachEnterButtonListener(new EnterNewVocabView.EnterButtonListener() {
            @Override
            public void pressed() {
                VocabItem vocabItem = new VocabItem(enterNewVocabView.getEnglishWord(), enterNewVocabView.getFrenchWord());
                vocabStorage.store(vocabItem);
            }
        });
    }
}
