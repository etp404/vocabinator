package uk.co.mould.matt.vocabinator;

import java.util.List;

public interface QueryView {
    void addQueryButtonListener(QueryButtonListener queryButtonListener);

    String getTextBoxString();

    void showResults(List<VocabItem> vocabItems);

    interface QueryButtonListener {
        void pressed();
    }
}
