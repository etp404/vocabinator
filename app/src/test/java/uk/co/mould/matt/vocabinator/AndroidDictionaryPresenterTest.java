package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AndroidDictionaryPresenterTest {

    @Test
    public void AndroidDictionaryPresenterTellsViewToShowDictionaryItems() {
        Set<VocabItem> vocabItems = new HashSet<VocabItem>() {{
            add(new VocabItem("a","b"));
        }};
        FakeVocabStorage fakeVocabStorage = new FakeVocabStorage(vocabItems);
        CapturingDictionaryView capturingDictionaryView = new CapturingDictionaryView();
        new AndroidDictionaryPresenter(capturingDictionaryView, fakeVocabStorage);

        assertThat(capturingDictionaryView.hasBeenToldToShow, is(vocabItems));
    }

    private class CapturingDictionaryView {
        public Set<VocabItem> hasBeenToldToShow;

        public void show(Set<VocabItem> vocabItems) {
            hasBeenToldToShow = vocabItems;
        }
    }

    private class AndroidDictionaryPresenter {
        public AndroidDictionaryPresenter(CapturingDictionaryView capturingDictionaryView, VocabStorage fakeVocabStorage) {
            capturingDictionaryView.show(fakeVocabStorage.getVocabItems());
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
