package com.enterprise.wrapup.wrapup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 22.09.2016.
 */
public class ListActivity extends android.app.ListActivity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW

    CustomAdapter adapter;
    public String [] items={"", "", ""};
    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    private static ListView lv_list;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItems.add("");
        listItems.add("");
        listItems.add("");
        adapter = new CustomAdapter(this, listItems);
        setListAdapter(adapter);
        setContentView(R.layout.activity_list);


//        adapter=new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                listItems);
//        setListAdapter(adapter);
    }


    public static void setMainList(ListView lv){
        lv_list = lv;
    }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("");
        adapter.notifyDataSetChanged();

    }

    public void gotoLocationActivity(View v){
        Intent myIntent = null;

        myIntent = new Intent(v.getContext(), LocationActivity.class);
        startActivity(myIntent);
    }
//    public void save(){
//        lv_list.add
//
//    }
}
