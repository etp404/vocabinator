package uk.co.mould.matt.vocabinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AndroidQueryView extends LinearLayout implements QueryView {
    private View queryButton;
    private EditText queryEntryBox;

    public AndroidQueryView(Context context) {
        super(context);
    }

    public AndroidQueryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidQueryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        queryButton = findViewById(R.id.query_button);
        queryEntryBox= (EditText) findViewById(R.id.query_entry_box);
    }

    @Override
    public void addQueryButtonListener(final QueryButtonListener queryButtonListener) {
        queryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                queryButtonListener.pressed();
            }
        });
    }

    @Override
    public String getTextBoxString() {
        return queryEntryBox.getText().toString();
    }
}
