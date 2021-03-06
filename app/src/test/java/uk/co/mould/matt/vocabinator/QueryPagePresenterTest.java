package uk.co.mould.matt.vocabinator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import uk.co.mould.matt.vocabinator.dictionary.QueryPagePresenter;
import uk.co.mould.matt.vocabinator.dictionary.QueryView;
import uk.co.mould.matt.vocabinator.dictionaryapi.VocabProvider;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QueryPagePresenterTest {
    private List<VocabItem> vocabItems = new ArrayList<VocabItem>() {{
        add(new VocabItem("a", "c"));
        add(new VocabItem("e", "g"));
    }};
    private AutomaticallyRespondingVocabProvider automaticallyRespondingVocabProvider;
    private String someWord;
    private FakeQueryView fakeQueryView;

    @Before
    public void setup() {
        automaticallyRespondingVocabProvider = new AutomaticallyRespondingVocabProvider(vocabItems);
        fakeQueryView = new FakeQueryView();
        new

                QueryPagePresenter(
                fakeQueryView,
                automaticallyRespondingVocabProvider
                );

        someWord = "someWord";
        fakeQueryView.setTextBoxString(someWord);
        fakeQueryView.queryButtonPressed();
    }

    @Test
    public void whenTranslateIsPressed_CallIsMadeToTranslationGetter() throws Exception {
        assertThat(automaticallyRespondingVocabProvider.calledWith, is(someWord));
    }

    @Test
    public void whenVocabProviderReturns_ViewIsToldToShowResults() {
        assertEquals(vocabItems, fakeQueryView.toldToShow);
    }

    private static class FakeQueryView implements QueryView {
        private QueryButtonListener queryButtonListener;
        private String textBoxString;
        public List<VocabItem> toldToShow;

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

        @Override
        public void showResults(List<VocabItem> vocabItems) {
            toldToShow = vocabItems;
        }
    }

    private class AutomaticallyRespondingVocabProvider implements VocabProvider {
        public String calledWith;
        private List<VocabItem> vocabItems;

        public AutomaticallyRespondingVocabProvider(List<VocabItem> vocabItems) {
            this.vocabItems = vocabItems;
        }

        @Override
        public void getVocabItem(String someWord, VocabCallback callback) {
            calledWith = someWord;
            callback.success(vocabItems);
        }
    }

}