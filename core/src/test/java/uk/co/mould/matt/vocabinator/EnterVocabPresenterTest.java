package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import uk.co.mould.matt.vocabinator.entry.EnterNewVocabPresenter;
import uk.co.mould.matt.vocabinator.entry.EnterNewVocabView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EnterVocabPresenterTest {

    @Test
    public void whenEnterButtonIsPressed_VocabIsStored() {
        String englishWord = "hello";
        String frenchWord = "bonjour";

        FakeVocabStorage fakeVocabStorage = new FakeVocabStorage();
        FakeEnterNewVocabView fakeEnterNewVocabView = new FakeEnterNewVocabView(englishWord, frenchWord);
        new EnterNewVocabPresenter(fakeEnterNewVocabView, fakeVocabStorage);

        fakeEnterNewVocabView.enterButtonPressed();

        assertThat(fakeVocabStorage.hasBeenToldToStore, is(new VocabItem(englishWord, frenchWord)));
    }

    private class FakeVocabStorage implements VocabStorage {
        public VocabItem hasBeenToldToStore;

        @Override
        public void store(VocabItem vocabItem) {
            hasBeenToldToStore = vocabItem;
        }

        @Override
        public List<VocabItem> getVocabItems() {
            return null;
        }
    }

    class FakeEnterNewVocabView implements EnterNewVocabView {
        private final String englishWord;
        private final String frenchWord;
        private EnterButtonListener enterButtonListener;

        public FakeEnterNewVocabView(String englishWord, String frenchWord) {
            this.englishWord = englishWord;
            this.frenchWord = frenchWord;
        }

        public void enterButtonPressed() {
            enterButtonListener.pressed();
        }

        @Override
        public String getEnglishWord() {
            return englishWord;
        }

        @Override
        public String getFrenchWord() {
            return frenchWord;
        }

        @Override
        public void attachEnterButtonListener(EnterButtonListener enterButtonListener) {
            this.enterButtonListener = enterButtonListener;
        }
    }

}