package com.enterprise.wrapup.wrapup;

/**
 * Created by admin on 28.09.2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> result;
    Context context;
    private static LayoutInflater inflater = null;

    public CustomAdapter(ListActivity mainActivity, ArrayList<String> items) {
        // TODO Auto-generated constructor stub
        result = items;
        context = mainActivity;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        EditText et_name;
        EditText et_anzahl;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.listitems, null);
        holder.et_name = (EditText) rowView.findViewById(R.id.et_name);
        holder.et_anzahl = (EditText) rowView.findViewById(R.id.et_anzahl);

        return rowView;
    }

}