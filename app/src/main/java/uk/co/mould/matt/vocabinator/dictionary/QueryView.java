package uk.co.mould.matt.vocabinator.dictionary;

import java.util.List;

import uk.co.mould.matt.vocabinator.VocabItem;

public interface QueryView {
    void addQueryButtonListener(QueryButtonListener queryButtonListener);

    String getTextBoxString();

    void showResults(List<VocabItem> vocabItems);

    interface QueryButtonListener {
        void pressed();
    }
}
