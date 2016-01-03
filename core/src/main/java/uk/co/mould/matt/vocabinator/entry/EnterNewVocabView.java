package uk.co.mould.matt.vocabinator.entry;

public interface EnterNewVocabView {
    String getEnglishWord();
    String getFrenchWord();

    void clearEnglishWord();

    void clearFrenchWord();


    interface EnterButtonListener {
        void pressed();
    }

    void attachEnterButtonListener(EnterButtonListener enterButtonListener);

}
