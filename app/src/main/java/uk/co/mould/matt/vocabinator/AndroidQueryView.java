package uk.co.mould.matt.vocabinator;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

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

    @Override
    public void showResults(List<VocabItem> vocabItems) {
        ListView resultsList = (ListView)findViewById(R.id.results_list);
        resultsList.setAdapter(new VocabItemsViewListadapter(getContext(), R.layout.vocab_item, vocabItems));
    }

    private static class VocabItemsViewListadapter extends ArrayAdapter<VocabItem> {

        public VocabItemsViewListadapter(Context context, int resource) {
            super(context, resource);
        }

        public VocabItemsViewListadapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public VocabItemsViewListadapter(Context context, int resource, VocabItem[] objects) {
            super(context, resource, objects);
        }

        public VocabItemsViewListadapter(Context context, int resource, int textViewResourceId, VocabItem[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public VocabItemsViewListadapter(Context context, int resource, List<VocabItem> objects) {
            super(context, resource, objects);
        }

        public VocabItemsViewListadapter(Context context, int resource, int textViewResourceId, List<VocabItem> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView==null) {
                convertView = mInflater.inflate(R.layout.vocab_item, null);
                VocabItemViewHolder vocabItemViewHolder = new VocabItemViewHolder(
                        (TextView)convertView.findViewById(R.id.english_word),
                        (TextView)convertView.findViewById(R.id.french_word));
                convertView.setTag(vocabItemViewHolder);
            }
            VocabItem vocabItem = getItem(position);
            VocabItemViewHolder viewHolder = (VocabItemViewHolder)convertView.getTag();
            viewHolder.frenchWord.setText(vocabItem.frenchWord);
            viewHolder.englishWord.setText(vocabItem.englishWord);
            return convertView;
        }

        public static class VocabItemViewHolder {
            public TextView englishWord;
            public TextView frenchWord;

            public VocabItemViewHolder(TextView englishWord, TextView frenchWord) {
                this.englishWord = englishWord;
                this.frenchWord = frenchWord;
            }
        }
    }
}
