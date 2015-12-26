package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DictionaryPresenterTest {

    @Test
    public void AndroidDictionaryPresenterTellsViewToShowDictionaryItems() {
        Set<VocabItem> vocabItems = new HashSet<VocabItem>() {{
            add(new VocabItem("a","b"));
        }};
        FakeVocabStorage fakeVocabStorage = new FakeVocabStorage(vocabItems);
        CapturingDictionaryView capturingDictionaryView = new CapturingDictionaryView();
        new DictionaryPresenter(capturingDictionaryView, fakeVocabStorage);

        assertThat(capturingDictionaryView.hasBeenToldToShow, is(vocabItems));
    }

    private class CapturingDictionaryView implements DictionaryView {
        public Set<VocabItem> hasBeenToldToShow;

        @Override
        public void show(Set<VocabItem> vocabItems) {
            hasBeenToldToShow = vocabItems;
        }
    }

    private class FakeVocabStorage implements VocabStorage {
        private Set<VocabItem> vocabItems;

        public FakeVocabStorage(Set<VocabItem> vocabItems) {
            this.vocabItems = vocabItems;
        }

        @Override
        public void store(VocabItem vocabItem) {

        }

        @Override
        public Set<VocabItem> getVocabItems() {
            return vocabItems;
        }
    }
}
