package uk.co.mould.matt.vocabinator;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_layout);

        ListView listView = (ListView)findViewById(R.id.list_view);
        String[] items = new String[1000];
        for (int i=0; i<items.length; i++) {
            items[i] = "abc";
        }

        listView.setAdapter(new MyArrayAdapter(this, R.layout.simple_listitem, items));
    }

    private class MyArrayAdapter extends ArrayAdapter<String> {

        public MyArrayAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView==null) {
                convertView = mInflater.inflate(R.layout.simple_listitem, null);
                ViewHolder viewHolder = new ViewHolder((TextView)convertView.findViewById(R.id.first_text), (TextView)convertView.findViewById(R.id.second_text));
                convertView.setTag(viewHolder);
            }
            String item = getItem(position);
            ViewHolder viewHolder = (ViewHolder)convertView.getTag();
            viewHolder.viewById.setText(item);
            viewHolder.viewById1.setText(String.valueOf(position));
            return convertView;
        }
    }

    private static class ViewHolder {

        public final TextView viewById;
        public final TextView viewById1;

        public ViewHolder(TextView viewById, TextView viewById1) {
            this.viewById = viewById;
            this.viewById1 = viewById1;
        }
    }
}
