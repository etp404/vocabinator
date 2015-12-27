package uk.co.mould.matt.vocabinator.entry;

import uk.co.mould.matt.vocabinator.VocabItem;
import uk.co.mould.matt.vocabinator.VocabStorage;

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
