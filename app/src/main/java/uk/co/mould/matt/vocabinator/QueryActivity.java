package uk.co.mould.matt.vocabinator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_layout);
        new QueryPagePresenter((AndroidQueryView)findViewById(R.id.android_query_view), new GlosbeVocabProvider(new StaticResponseGetter()));
    }
}
