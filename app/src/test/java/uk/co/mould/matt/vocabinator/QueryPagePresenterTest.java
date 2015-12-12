package uk.co.mould.matt.vocabinator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QueryPagePresenterTest {
    @Test
    public void assertThatWhenTranslateIsPressed_CallIsMadeToTranslationGetter() throws Exception {

        FakeVocabProvider fakeVocabProvider = new FakeVocabProvider();
        FakeQueryView fakeQueryView = new FakeQueryView();
        new QueryPagePresenter(
                fakeQueryView,
                fakeVocabProvider
                );

        fakeQueryView.queryButtonPressed();
        assertThat(fakeVocabProvider.calledWith, is("some_word"));
    }

    private class QueryPagePresenter {
        public QueryPagePresenter(QueryView queryView, final VocabProvider vocabProvider) {
            queryView.addQueryButtonListener(new QueryView.QueryButtonListener() {
                @Override
                public void pressed() {
                    vocabProvider.getVocabItem("some_word");
                }
            });
        }
    }

    private static class FakeQueryView implements QueryView {
        private QueryButtonListener queryButtonListener;

        public void queryButtonPressed() {
            queryButtonListener.pressed();
        }

        @Override
        public void addQueryButtonListener(QueryButtonListener queryButtonListener) {
            this.queryButtonListener = queryButtonListener;
        }

    }

    private class FakeVocabProvider implements VocabProvider {
        public String calledWith;

        @Override
        public void getVocabItem(String some_word) {
            calledWith = some_word;
        }
    }
}