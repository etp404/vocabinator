package uk.co.mould.matt.vocabinator;

import android.test.AndroidTestCase;

import java.util.Set;

public class SharedPreferencesVocabStorageTest extends AndroidTestCase {

    public void testThatCanStoreAndClearVocabItems() {
        SharedPreferencesVocabStorage sharedPreferencesVocabStorage = new SharedPreferencesVocabStorage(getContext());
        VocabItem vocabItem1 = new VocabItem("a", "b");
        VocabItem vocabItem2 = new VocabItem("c", "d");

        sharedPreferencesVocabStorage.store(vocabItem1);
        sharedPreferencesVocabStorage.store(vocabItem2);
        sharedPreferencesVocabStorage.clear();
        Set<VocabItem> vocabItems = sharedPreferencesVocabStorage.getVocabItems();

        assertEquals(vocabItems.size(), 0);
    }

    public void testThatCanStoreAndGetVocabItems() {
        SharedPreferencesVocabStorage sharedPreferencesVocabStorage = new SharedPreferencesVocabStorage(getContext());
        VocabItem vocabItem1 = new VocabItem("a", "b");
        VocabItem vocabItem2 = new VocabItem("c", "d");

        sharedPreferencesVocabStorage.store(vocabItem1);
        sharedPreferencesVocabStorage.store(vocabItem2);
        Set<VocabItem> vocabItems = sharedPreferencesVocabStorage.getVocabItems();

        assertTrue(vocabItems.contains(vocabItem1));
        assertTrue(vocabItems.contains(vocabItem2));
        assertEquals(vocabItems.size(), 2);
    }
}
