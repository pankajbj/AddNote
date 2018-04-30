package com.example.acer.addnote;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Acer on 26-03-2018.
 */
public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.onerow,parent,false);

        return row;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView textView=(TextView)view.findViewById(R.id.textView);
        String title=cursor.getString(cursor.getColumnIndexOrThrow("Title"));
        textView.setText(title);
    }
}
