package com.enterprise.wrapup.wrapup;

/**
 * Created by admin on 28.09.2016.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> items;
    ArrayList<String> menge;
    Context context;
    private static LayoutInflater inflater = null;
    private boolean init = true;


    public CustomAdapter(ListActivity mainActivity, ArrayList<String> items, ArrayList<String> anzahl) {
        // TODO Auto-generated constructor stub
        this.items = items;
        menge = anzahl;
        context = mainActivity;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        EditText et_name;
        EditText et_anzahl;
        int id;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder  holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.listitems, null);
        holder.et_name = (EditText) rowView.findViewById(R.id.et_name);
        holder.et_anzahl = (EditText) rowView.findViewById(R.id.et_anzahl);


        if(position <= items.size()-1) {
            if (items.get(position) != null && menge.get(position) != null){
                holder.et_name.setText(items.get(position));
                holder.et_anzahl.setText(menge.get(position));
            }else{
                holder.et_name.setText(null);
                holder.et_anzahl.setText(null);
            }


        }



        if(position == menge.size()-1){
            init = false;
        }
//        if(init){
            holder.et_anzahl.setId(position);
            holder.et_name.setId(position);
            holder.id = position;
//        }

        holder.et_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = ((EditText) v).getText()
                            .toString();
                    int id = holder.et_name.getId();
                    try {
                        if (id <= items.size()){
                            items.set(id, name);
                        }else{
                            items.add(name);
                        }
                    }catch (Exception e){
                        return;
                    }


                }
            }
        });

        holder.et_anzahl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String anzahl = ((EditText) v).getText()
                            .toString();

                    int id = holder.et_anzahl.getId();
                    if (id <= menge.size()){
                        menge.set(id, anzahl);
                    }else{
                        menge.add(anzahl);
                    }
                }
            }
        });


        holder.et_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                edittext.setFocusableInTouchMode(true);
                Log.d("request", " focus");
                holder.et_name.requestFocus();
            }
        });
        rowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int id = holder.et_anzahl.getId();
                items.remove(id);
                menge.remove(id);
//                v.requestFocus();
                notifyDataSetChanged();
                return true;
            }
        });
        return rowView;
    }

    public ArrayList<String> getItems(){
        return items;
    }
    public ArrayList<String> getMenge(){
        return menge;
    }

}