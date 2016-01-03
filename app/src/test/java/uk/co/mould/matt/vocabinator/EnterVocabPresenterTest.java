package uk.co.mould.matt.vocabinator;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import uk.co.mould.matt.vocabinator.entry.EnterNewVocabPresenter;
import uk.co.mould.matt.vocabinator.entry.EnterNewVocabView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EnterVocabPresenterTest {

    private FakeEnterNewVocabView fakeEnterNewVocabView;
    private FakeVocabStorage fakeVocabStorage;
    private String englishWord = "hello";
    private String frenchWord = "bonjour";

    @Before
    public void setup() {
        fakeVocabStorage = new FakeVocabStorage();
        fakeEnterNewVocabView = new FakeEnterNewVocabView(englishWord, frenchWord);
        new EnterNewVocabPresenter(fakeEnterNewVocabView, fakeVocabStorage);

        fakeEnterNewVocabView.enterButtonPressed();
    }

    @Test
    public void whenEnterButtonIsPressed_VocabIsStored() {
        assertThat(fakeVocabStorage.hasBeenToldToStore, is(new VocabItem(englishWord, frenchWord)));
    }

    @Test
    public void whenEnterButtonIsPressed_EntryBoxesAreCleared() {
        assertTrue(fakeEnterNewVocabView.englishWordCleared);
        assertTrue(fakeEnterNewVocabView.frenchWordCleared);
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
        public boolean englishWordCleared = false;
        public boolean frenchWordCleared;

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
        public void clearEnglishWord() {
            englishWordCleared = true;
        }

        @Override
        public void clearFrenchWord() {
            frenchWordCleared = true;
        }

        @Override
        public void attachEnterButtonListener(EnterButtonListener enterButtonListener) {
            this.enterButtonListener = enterButtonListener;
        }
    }

}