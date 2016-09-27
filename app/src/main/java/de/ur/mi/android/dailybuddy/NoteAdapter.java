package de.ur.mi.android.dailybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chris on 26.09.2016.
 */
public class NoteAdapter extends ArrayAdapter<String> {

    private ArrayList<String> noteList;
    private Context context;

    public NoteAdapter(Context context, ArrayList<String> noteList) {
        super(context, R.layout.list_item_note, noteList);

        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_note, null);

        }

        String note = noteList.get(position);

        if (note != null) {
            TextView text = (TextView) v.findViewById(R.id.text);

            text.setText(note);
        }

        return v;
    }

}
