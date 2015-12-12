package uk.co.mould.matt.vocabinator;

public interface QueryView {
    void addQueryButtonListener(QueryButtonListener queryButtonListener);

    String getTextBoxString();

    interface QueryButtonListener {
        void pressed();
    }
}
