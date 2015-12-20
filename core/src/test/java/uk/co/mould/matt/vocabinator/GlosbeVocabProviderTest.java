package uk.co.mould.matt.vocabinator;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class GlosbeVocabProviderTest {

    @Test
    public void testThatCanReturnArrayOfMeanings() {

        CapturingCallback vocabCallback = new CapturingCallback();
        final String frenchWord = "ainsi";
        List<VocabItem> vocabItems = new ArrayList<VocabItem>() {{
            add(new VocabItem("so", frenchWord));
            add(new VocabItem("thus", frenchWord));
            add(new VocabItem("such", frenchWord));
            add(new VocabItem("hence", frenchWord));
            add(new VocabItem("thereby", frenchWord));
            add(new VocabItem("in this way", frenchWord));
        }};
        new GlosbeVocabProvider(new FileReaderResponseGetter()).getVocabItem(frenchWord, vocabCallback);
        assertEquals(vocabItems, vocabCallback.vocabItems);
    }

    private class CapturingCallback implements VocabProvider.VocabCallback {
        private List<VocabItem> vocabItems;

        @Override
        public void success(List<VocabItem> vocabItems) {
            this.vocabItems = vocabItems;
        }
    }
}