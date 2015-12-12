package uk.co.mould.matt.vocabinator;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public final class GlosbeVocabProviderTest {

    @Test
    public void testThatCanReturnArrayOfMeanings() {
        assertEquals("so", new GlosbeVocabProvider(new StaticResponseGetter()).getVocabItem("some_word"));
    }



}