package uk.co.mould.matt.vocabinator.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.mould.matt.vocabinator.R;

public class AndroidEnterNewVocabItemView extends LinearLayout implements uk.co.mould.matt.vocabinator.entry.EnterNewVocabView {

    public AndroidEnterNewVocabItemView(Context context) {
        super(context);
    }

    public AndroidEnterNewVocabItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidEnterNewVocabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public String getEnglishWord() {
        return ((TextView)findViewById(R.id.english_word)).getText().toString();
    }

    @Override
    public String getFrenchWord() {
        return ((TextView)findViewById(R.id.french_word)).getText().toString();
    }

    @Override
    public void clearEnglishWord() {

    }

    @Override
    public void clearFrenchWord() {

    }

    @Override
    public void attachEnterButtonListener(final EnterButtonListener enterButtonListener) {
        findViewById(R.id.enter_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                enterButtonListener.pressed();
            }
        });
    }
}
