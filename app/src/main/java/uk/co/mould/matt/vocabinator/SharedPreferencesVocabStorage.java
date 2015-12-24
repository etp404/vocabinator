package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPreferencesVocabStorage implements VocabStorage {

    private static final String VOCAB_STORAGE = "VOCAB_STORAGE";
    private final List<VocabItem> internalList;
    private final SharedPreferences sharedPreferences;
    private String vocab_items_key = "vocab_items_key";
    private Gson gson;
    ;

    public SharedPreferencesVocabStorage(Context context) {
        gson = new Gson();
        sharedPreferences = context.getSharedPreferences(VOCAB_STORAGE, Context.MODE_PRIVATE);
        internalList = new ArrayList<>();
    }

    @Override
    public void store(VocabItem vocabItem) {
        Set<String> vocabItems = sharedPreferences.getStringSet(vocab_items_key, new HashSet<String>());
        vocabItems.add(gson.toJson(vocabItem).toString());
        sharedPreferences.edit().putStringSet(vocab_items_key, vocabItems).apply();
        internalList.add(vocabItem);
    }

    @Override
    public Set<VocabItem> getVocabItems() {
        Set<VocabItem> vocabItems = new HashSet<>();
        Set<String> vocabItemsAsString = sharedPreferences.getStringSet(vocab_items_key, new HashSet<String>());
        for (String vocabItemAsString : vocabItemsAsString) {
            vocabItems.add(gson.fromJson(vocabItemAsString, VocabItem.class));
        }

        return vocabItems;
    }

    public void clear() {
        sharedPreferences.edit().putStringSet(vocab_items_key, new HashSet<String>()).apply();
    }
}
