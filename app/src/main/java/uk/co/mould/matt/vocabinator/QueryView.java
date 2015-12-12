package uk.co.mould.matt.vocabinator;

public interface QueryView {
    void addQueryButtonListener(QueryButtonListener queryButtonListener);

    interface QueryButtonListener {
        void pressed();
    }
}
