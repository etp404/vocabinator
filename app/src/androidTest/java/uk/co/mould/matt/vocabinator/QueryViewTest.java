package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.widget.EditText;

import uk.co.mould.matt.vocabinator.dictionary.QueryView;
import uk.co.mould.matt.vocabinator.entry.AndroidQueryView;

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

//    public void testThatCanShowList() {
//        final VocabItem vocabItem1 = new VocabItem("a", "b");
//        final VocabItem vocabItem2 = new VocabItem("c", "d");
//
//        List<VocabItem> vocabItems = new ArrayList<VocabItem>(){{
//            add(vocabItem1);
//            add(vocabItem2);
//        }};
//        queryView.showResults(vocabItems);
//
//        ListView resultsList = (ListView)queryView.findViewById(R.id.results_list);
//        assertEquals(vocabItem1, resultsList.getItemAtPosition(0));
//        assertEquals(vocabItem2, resultsList.getItemAtPosition(1));
//    }

    private static class CapturingQueryButtonListener implements QueryView.QueryButtonListener {
        private boolean invoked;

        @Override
        public void pressed() {
            invoked = true;
        }
    }
}
