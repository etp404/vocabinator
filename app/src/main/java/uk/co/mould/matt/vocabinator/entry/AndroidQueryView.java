package uk.co.mould.matt.vocabinator.entry;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import uk.co.mould.matt.vocabinator.QueryView;
import uk.co.mould.matt.vocabinator.R;
import uk.co.mould.matt.vocabinator.VocabItem;

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
    public void showResults(final List<VocabItem> vocabItems) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                ListView resultsList = (ListView) findViewById(R.id.results_list);
                resultsList.setAdapter(new VocabItemsViewListAdapter(getContext(),R.layout.vocab_item,vocabItems));
            }

        };
        post(runnable);
    }

    private static class VocabItemsViewListAdapter extends ArrayAdapter<VocabItem> {

        public VocabItemsViewListAdapter(Context context, int resource) {
            super(context, resource);
        }

        public VocabItemsViewListAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public VocabItemsViewListAdapter(Context context, int resource, VocabItem[] objects) {
            super(context, resource, objects);
        }

        public VocabItemsViewListAdapter(Context context, int resource, int textViewResourceId, VocabItem[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public VocabItemsViewListAdapter(Context context, int resource, List<VocabItem> objects) {
            super(context, resource, objects);
        }

        public VocabItemsViewListAdapter(Context context, int resource, int textViewResourceId, List<VocabItem> objects) {
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
