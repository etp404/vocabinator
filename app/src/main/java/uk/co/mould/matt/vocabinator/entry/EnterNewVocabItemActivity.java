package uk.co.mould.matt.vocabinator.entry;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.mould.matt.vocabinator.R;
import uk.co.mould.matt.vocabinator.SharedPreferencesVocabStorage;
import uk.co.mould.matt.vocabinator.dictionary.DictionaryActivity;

public class EnterNewVocabItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_new_vocab_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AndroidEnterNewVocabItemView androidEnterNewVocabItemView = (AndroidEnterNewVocabItemView)findViewById(R.id.android_enter_new_vocab_item_view);
        new EnterNewVocabPresenter(androidEnterNewVocabItemView, new SharedPreferencesVocabStorage(getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.dicationary_view) {
            startActivity(new Intent(this, DictionaryActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
