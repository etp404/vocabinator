package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.widget.EditText;

public final class QueryViewTest extends AndroidTestCase {

    private AndroidQueryView queryView;
    private CapturingQueryButtonListener queryButtonListener;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Context context = getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        queryView = (AndroidQueryView)layoutInflater.inflate(R.layout.query_layout, null);
        queryButtonListener = new CapturingQueryButtonListener();
        queryView.addQueryButtonListener(queryButtonListener);
    }

    public void testThatWhenButtonIsPressedListenersAreInvoked() {
        queryView.findViewById(R.id.query_button).performClick();
        assertTrue(queryButtonListener.invoked);
    }

    public void testThatCanGetTextFromTextBox() {
        String text = "some text";
        ((EditText)queryView.findViewById(R.id.query_entry_box)).setText(text);
        assertEquals(text, queryView.getTextBoxString());
    }

    private static class CapturingQueryButtonListener implements QueryView.QueryButtonListener {
        private boolean invoked;

        @Override
        public void pressed() {
            invoked = true;
        }
    }
}
