package uk.co.mould.matt.vocabinator.entry;

public interface EnterNewVocabView {
    String getEnglishWord();
    String getFrenchWord();


    interface EnterButtonListener {
        void pressed();
    }

    void attachEnterButtonListener(EnterButtonListener enterButtonListener);

}
