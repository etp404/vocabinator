package uk.co.mould.matt.vocabinator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EnterNewVocabItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_new_vocab_layout);
        AndroidEnterNewVocabItemView androidEnterNewVocabItemView = (AndroidEnterNewVocabItemView)findViewById(R.id.android_enter_new_vocab_item_view);
    }
}
