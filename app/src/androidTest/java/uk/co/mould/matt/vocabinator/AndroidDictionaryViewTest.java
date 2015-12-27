package uk.co.mould.matt.vocabinator;

import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AndroidDictionaryViewTest extends AndroidTestCase {
    public void testThatVocabItemsCanBeShown() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        AndroidDictionaryView dictionaryView = (AndroidDictionaryView) layoutInflater.inflate(R.layout.dictionary_view, null);
        List<VocabItem> vocabItems = new ArrayList<VocabItem>() {{
            add(new VocabItem("a","b'"));
            add(new VocabItem("c","d'"));
        }};

        dictionaryView.show(vocabItems);

        ListView dictionaryListView = (ListView)dictionaryView.findViewById(R.id.dictionary_list);
        assertEquals(dictionaryListView.getItemAtPosition(0), vocabItems.get(0));
        assertEquals(dictionaryListView.getItemAtPosition(1), vocabItems.get(1));
    }

}
