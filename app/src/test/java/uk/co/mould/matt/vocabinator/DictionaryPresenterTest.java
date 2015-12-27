package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uk.co.mould.matt.vocabinator.dictionary.DictionaryPresenter;
import uk.co.mould.matt.vocabinator.dictionary.DictionaryView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DictionaryPresenterTest {

    @Test
    public void AndroidDictionaryPresenterTellsViewToShowDictionaryItems() {
        List<VocabItem> vocabItems = new ArrayList<VocabItem>() {{
            add(new VocabItem("a","b"));
        }};
        FakeVocabStorage fakeVocabStorage = new FakeVocabStorage(vocabItems);
        CapturingDictionaryView capturingDictionaryView = new CapturingDictionaryView();
        new DictionaryPresenter(capturingDictionaryView, fakeVocabStorage);

        assertThat(capturingDictionaryView.hasBeenToldToShow, is(vocabItems));
    }

    private class CapturingDictionaryView implements DictionaryView {
        public List<VocabItem> hasBeenToldToShow;

        @Override
        public void show(List<VocabItem> vocabItems) {
            hasBeenToldToShow = vocabItems;
        }
    }

    private class FakeVocabStorage implements VocabStorage {
        private List<VocabItem> vocabItems;

        public FakeVocabStorage(List<VocabItem> vocabItems) {
            this.vocabItems = vocabItems;
        }

        @Override
        public void store(VocabItem vocabItem) {

        }

        @Override
        public List<VocabItem> getVocabItems() {
            return vocabItems;
        }
    }
}
