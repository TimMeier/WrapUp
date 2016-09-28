package com.enterprise.wrapup.wrapup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by admin on 22.09.2016.
 */
public class ListActivity extends android.app.ListActivity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW

    CustomAdapter adapter;
    ArrayList<String> items = new ArrayList(Arrays.asList("Apfel", "Ananas", "Nix"));
    ArrayList<String> menge = new ArrayList(Arrays.asList("2", "3", "4"));
    EditText et_listname;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItems.add("");
        listItems.add("");
        listItems.add("");

        et_listname = (EditText) findViewById(R.id.tv_name);
        adapter = new CustomAdapter(this, items, menge);
        setListAdapter(adapter);
        setContentView(R.layout.activity_list);

    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        items.add("");
        menge.add("");
        adapter.notifyDataSetChanged();

    }

    public void gotoLocationActivity(View v){
        Intent myIntent = null;

        myIntent = new Intent(v.getContext(), LocationActivity.class);
        startActivity(myIntent);
    }
    public void save(View v){
        FileManager fileManager = new FileManager();
        MainClass mainClass = new MainClass();
        mainClass.mappToBackend(adapter.getItems(), adapter.getMenge(), new ArrayList<Boolean>(), et_listname.getEditableText().toString());
        fileManager.exportFile(fileManager.toJson(mainClass.getLists()));

    }
}
