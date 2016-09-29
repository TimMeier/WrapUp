package com.enterprise.wrapup.wrapup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
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
    static ArrayList<String> items ;
//            = new ArrayList(Arrays.asList("Apfel", "Ananas", "Nix"));
    static ArrayList<String> menge ;
//        = new ArrayList(Arrays.asList("2", "3", "4"));
    EditText et_listname;
    public static FileManager fileManager;
    public static MainClass mainClass;
    public static ArrayAdapter<String> list_adapter;
    public static String name;
    public static int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (items == null){
            items = new ArrayList<String>();
            items.add("");
            items.add("");
            items.add("");
        }
        if (menge == null){
            menge = new ArrayList<String>();
            menge.add("");
            menge.add("");
            menge.add("");
        }
        adapter = new CustomAdapter(this, items, menge);


        setListAdapter(adapter);

        setContentView(R.layout.activity_list);
//        et_listname.setText("");
        if (name != null){
            et_listname = (EditText) findViewById(R.id.tv_name);
            et_listname.setText(name);
        }

    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        items.add("");
        menge.add("");
        adapter.notifyDataSetChanged();

    }

    public static void setItems(ArrayList<String> items1){
        items = items1;
    }

    public static void setMenge(ArrayList<String> menge1){
        menge = menge1;
    }
    public void gotoLocationActivity(View v){
        try {
            Intent myIntent = null;
            myIntent = new Intent(v.getContext(), LocationActivity.class);
            startActivity(myIntent);
        }catch (Exception e){
            Toast.makeText(this, "Dieses Feature ist noch nicht verfügbar!",
                    Toast.LENGTH_LONG).show();
        }

    }
    public static void setName(String i_name){
        name = i_name;
    }
    public void save(View v){
        Log.d("Event", "vor schreiben");

        et_listname = (EditText) findViewById(R.id.tv_name);
        mainClass.mappToBackend(adapter.getItems(), adapter.getMenge(), new ArrayList<Boolean>(Arrays.asList(false, false, false)), et_listname.getEditableText().toString(), position);
        if(
        fileManager.exportFile(fileManager.toJson(mainClass.getLists()), getApplicationContext())){
            Toast.makeText(this, "Liste gespeichert",
                    Toast.LENGTH_LONG).show();
            String json = fileManager.importFromFile(this);
            mainClass.setLists(fileManager.jsonToString(json));

//            list_adapter.clear();
//            list_adapter.addAll(mainClass.getLists_String());
            list_adapter.notifyDataSetChanged();
            items = null;
            menge = null;
            et_listname.setText("");
            finish();
        }else{
            Toast.makeText(this, "Liste konnte nicht gespeichert werden",
                    Toast.LENGTH_LONG).show();
            finish();
        }

    }
    public static void setter(FileManager manager, MainClass main, ArrayAdapter<String> adapter){
        fileManager = manager;
        mainClass = main;
        list_adapter = adapter;

    }
    public static void setIndex(int index){
        position = index;
    }
    public static void reset(){
        if (items != null) {
            items.clear();
            items.add("");
            items.add("");
            items.add("");
        }
        if (menge != null) {
            menge.clear();
            menge.add("");
            menge.add("");
            menge.add("");
        }
        name = null;
    }
}
