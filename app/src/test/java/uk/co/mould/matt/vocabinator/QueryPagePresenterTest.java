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

        String some_word = "some_word";
        fakeQueryView.setTextBoxString(some_word);
        fakeQueryView.queryButtonPressed();
        assertThat(fakeVocabProvider.calledWith, is(some_word));
    }

    private class QueryPagePresenter {
        public QueryPagePresenter(final QueryView queryView, final VocabProvider vocabProvider) {
            queryView.addQueryButtonListener(new QueryView.QueryButtonListener() {
                @Override
                public void pressed() {
                    vocabProvider.getVocabItem(queryView.getTextBoxString());
                }
            });
        }
    }

    private static class FakeQueryView implements QueryView {
        private QueryButtonListener queryButtonListener;
        private String textBoxString;

        public void queryButtonPressed() {
            queryButtonListener.pressed();
        }

        @Override
        public void addQueryButtonListener(QueryButtonListener queryButtonListener) {
            this.queryButtonListener = queryButtonListener;
        }

        public void setTextBoxString(String textBoxString) {
            this.textBoxString = textBoxString;
        }

        @Override
        public String getTextBoxString() {
            return textBoxString;
        }
    }

    private class FakeVocabProvider implements VocabProvider {
        public String calledWith;

        @Override
        public String getVocabItem(String some_word) {
            calledWith = some_word;
            return null;
        }
    }
}