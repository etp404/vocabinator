package uk.co.mould.matt.vocabinator.dictionary;

import android.app.Activity;
import android.os.Bundle;

import uk.co.mould.matt.vocabinator.R;
import uk.co.mould.matt.vocabinator.SharedPreferencesVocabStorage;

public class DictionaryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_view);
        AndroidDictionaryView androidEnterNewVocabItemView = (AndroidDictionaryView)findViewById(R.id.dictionary_view);
        new DictionaryPresenter(androidEnterNewVocabItemView, new SharedPreferencesVocabStorage(getApplicationContext()));
    }
}
