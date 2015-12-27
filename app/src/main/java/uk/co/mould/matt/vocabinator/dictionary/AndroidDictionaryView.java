package uk.co.mould.matt.vocabinator.dictionary;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Set;

import uk.co.mould.matt.vocabinator.R;
import uk.co.mould.matt.vocabinator.VocabItem;

public class AndroidDictionaryView extends LinearLayout implements DictionaryView {
    public AndroidDictionaryView(Context context) {
        super(context);
    }

    public AndroidDictionaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AndroidDictionaryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void show(List<VocabItem> vocabItems) {
        ListView dictionaryList = (ListView)findViewById(R.id.dictionary_list);
        dictionaryList.setAdapter(new VocabItemsViewListAdapter(getContext(),R.layout.vocab_item,vocabItems));
    }

    private static class VocabItemsViewListAdapter extends ArrayAdapter<VocabItem> {
        public VocabItemsViewListAdapter(Context context, int resource, List<VocabItem> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.vocab_item, null);
                VocabItemViewHolder vocabItemViewHolder = new VocabItemViewHolder(
                        (TextView) convertView.findViewById(R.id.english_word),
                        (TextView) convertView.findViewById(R.id.french_word));
                convertView.setTag(vocabItemViewHolder);
            }
            VocabItem vocabItem = getItem(position);
            VocabItemViewHolder viewHolder = (VocabItemViewHolder) convertView.getTag();
            viewHolder.frenchWord.setText(vocabItem.frenchWord);
            viewHolder.englishWord.setText(vocabItem.englishWord);
            return convertView;
        }

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
