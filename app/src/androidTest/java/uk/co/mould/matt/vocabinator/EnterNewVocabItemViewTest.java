package uk.co.mould.matt.vocabinator;

import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.widget.TextView;

public class EnterNewVocabItemViewTest extends AndroidTestCase {

    private AndroidEnterNewVocabItem enterNewVocabItemView;

    public void setUp() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        enterNewVocabItemView = (AndroidEnterNewVocabItem) layoutInflater.inflate(R.layout.enter_new_vocab_layout, null);
    }

    public void testThatListenerIsInformedWhenStoreWordButtonIsPressed() {
       CapturingEnterButtonListener capturingEnterButtonListener = new CapturingEnterButtonListener();
        enterNewVocabItemView.attachEnterButtonListener(capturingEnterButtonListener);
        enterNewVocabItemView.findViewById(R.id.enter_button).performClick();

        assertTrue(capturingEnterButtonListener.buttonPressed);
    }

    public void testThatCanGetTheWordsFromTheBoxes() {
        String englishWord = "englishWord";
        String frenchWord = "frenchWord";
        ((TextView)enterNewVocabItemView.findViewById(R.id.english_word)).setText(englishWord);
        ((TextView)enterNewVocabItemView.findViewById(R.id.french_word)).setText(frenchWord);
        assertEquals(englishWord, enterNewVocabItemView.getEnglishWord());
        assertEquals(frenchWord, enterNewVocabItemView.getFrenchWord());
    }


    private static class CapturingEnterButtonListener implements EnterNewVocabView.EnterButtonListener {
        private boolean buttonPressed = false;

        @Override
        public void pressed() {
            buttonPressed = true;
        }
    }
}
