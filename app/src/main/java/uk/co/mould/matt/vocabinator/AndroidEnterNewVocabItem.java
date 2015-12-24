package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class AndroidEnterNewVocabItem extends LinearLayout implements EnterNewVocabView {

    public AndroidEnterNewVocabItem(Context context) {
        super(context);
    }

    public AndroidEnterNewVocabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidEnterNewVocabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public String getEnglishWord() {
        return null;
    }

    @Override
    public String getFrenchWord() {
        return null;
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
