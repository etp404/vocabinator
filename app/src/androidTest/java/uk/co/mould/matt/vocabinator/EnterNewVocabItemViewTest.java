package uk.co.mould.matt.vocabinator;

import android.test.AndroidTestCase;
import android.view.LayoutInflater;

public class EnterNewVocabItemViewTest extends AndroidTestCase {

    public void testThatListenerIsInformedWhenStoreWordButtonIsPressed() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        AndroidEnterNewVocabItem enterNewVocabItemView = (AndroidEnterNewVocabItem) layoutInflater.inflate(R.layout.enter_new_vocab_layout, null);

        CapturingEnterButtonListener capturingEnterButtonListener = new CapturingEnterButtonListener();
        enterNewVocabItemView.attachEnterButtonListener(capturingEnterButtonListener);
        enterNewVocabItemView.findViewById(R.id.enter_button).performClick();

        assertTrue(capturingEnterButtonListener.buttonPressed);

    }

    private static class CapturingEnterButtonListener implements EnterNewVocabView.EnterButtonListener {
        private boolean buttonPressed = false;

        @Override
        public void pressed() {
            buttonPressed = true;
        }
    }
}
