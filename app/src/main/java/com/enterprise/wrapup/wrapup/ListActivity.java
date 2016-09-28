package com.enterprise.wrapup.wrapup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

/**
 * Created by admin on 22.09.2016.
 */
public class ListActivity extends android.app.ListActivity {

    CustomAdapter adapter;
    ArrayList<String> items = new ArrayList(Arrays.asList("Apfel", "Ananas", "Nix"));
    ArrayList<String> menge = new ArrayList(Arrays.asList("2", "3", "4"));
    EditText et_listname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        Log.d("Event", "vor schreiben");
        FileManager fileManager = new FileManager();
        MainClass mainClass = new MainClass();
        et_listname = (EditText) findViewById(R.id.tv_name);
        mainClass.mappToBackend(adapter.getItems(), adapter.getMenge(), new ArrayList<Boolean>(Arrays.asList(false, false, false)), et_listname.getEditableText().toString());
        if(
        fileManager.exportFile(fileManager.toJson(mainClass.getLists()), getApplicationContext())){
            Toast.makeText(this, "Liste gespeichert",
                    Toast.LENGTH_LONG).show();
            finish();
        }else{
            Toast.makeText(this, "Liste konnte nicht gespeichert werden",
                    Toast.LENGTH_LONG).show();
            finish();
        }

    }
}
