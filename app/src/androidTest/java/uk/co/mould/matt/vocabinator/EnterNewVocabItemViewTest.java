package uk.co.mould.matt.vocabinator;

import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.widget.TextView;

import uk.co.mould.matt.vocabinator.entry.AndroidEnterNewVocabItemView;
import uk.co.mould.matt.vocabinator.entry.EnterNewVocabView;

public class EnterNewVocabItemViewTest extends AndroidTestCase {

    private AndroidEnterNewVocabItemView enterNewVocabItemView;
    private final String englishWord = "englishWord";
    private final String frenchWord = "frenchWord";

    public void setUp() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        enterNewVocabItemView = (AndroidEnterNewVocabItemView) layoutInflater.inflate(R.layout.enter_new_vocab_layout, null);
    }

    public void testThatListenerIsInformedWhenStoreWordButtonIsPressed() {
        CapturingEnterButtonListener capturingEnterButtonListener = new CapturingEnterButtonListener();
        enterNewVocabItemView.attachEnterButtonListener(capturingEnterButtonListener);
        enterNewVocabItemView.findViewById(R.id.enter_button).performClick();

        assertTrue(capturingEnterButtonListener.buttonPressed);
    }

    public void testThatCanGetTheWordsFromTheBoxes() {
        ((TextView)enterNewVocabItemView.findViewById(R.id.english_word)).setText(englishWord);
        ((TextView)enterNewVocabItemView.findViewById(R.id.french_word)).setText(frenchWord);
        assertEquals(englishWord, enterNewVocabItemView.getEnglishWord());
        assertEquals(frenchWord, enterNewVocabItemView.getFrenchWord());
    }

    public void testThatCanClearEnglishWordFromView(){
        ((TextView)enterNewVocabItemView.findViewById(R.id.english_word)).setText(englishWord);
        enterNewVocabItemView.clearEnglishWord();
        TextView englishWordElement = (TextView) enterNewVocabItemView.findViewById(R.id.english_word);
        assertEquals(0, englishWordElement.getText().length());
    }

    public void testThatCanClearFrenchWordFromView(){
        ((TextView)enterNewVocabItemView.findViewById(R.id.french_word)).setText(frenchWord);
        enterNewVocabItemView.clearFrenchWord();
        TextView frenchWordElement = (TextView) enterNewVocabItemView.findViewById(R.id.french_word);
        assertEquals(0, frenchWordElement.getText().length());
    }


    private static class CapturingEnterButtonListener implements EnterNewVocabView.EnterButtonListener {
        private boolean buttonPressed = false;

        @Override
        public void pressed() {
            buttonPressed = true;
        }
    }
}
