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
        public QueryPagePresenter(FakeQueryView fakeQueryView, final FakeVocabProvider fakeVocabProvider) {
            fakeQueryView.addQueryButtonListener(new FakeQueryView.QueryButtonListener() {
                @Override
                public void pressed() {
                    fakeVocabProvider.getVocabItem("some_word");
                }
            });
        }
    }

    private static class FakeQueryView {
        private QueryButtonListener queryButtonListener;

        public void queryButtonPressed() {
            queryButtonListener.pressed();
        }

        public void addQueryButtonListener(QueryButtonListener queryButtonListener) {
            this.queryButtonListener = queryButtonListener;
        }

        public interface QueryButtonListener {
            void pressed();
        }
    }

    private class FakeVocabProvider {
        public String calledWith;

        public void getVocabItem(String some_word) {
            calledWith = some_word;
        }
    }
}