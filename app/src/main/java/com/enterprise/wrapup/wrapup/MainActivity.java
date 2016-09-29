package com.enterprise.wrapup.wrapup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
// This is a Test

public class MainActivity extends AppCompatActivity {



    MainClass obj;
    FileManager fileManager;
    ArrayAdapter<String> arrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //liste erstellen
        obj = new MainClass();
        fileManager = new FileManager();

        String json = fileManager.importFromFile(this);
        if(json != null){
            obj.setLists(fileManager.jsonToString(json));

        }
        lv = (ListView) findViewById(R.id.lv_list);
        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                obj.getLists_String());
        ListActivity.setter(fileManager, obj, arrayAdapter);
        lv.setAdapter(arrayAdapter);



        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                obj.deleteList(pos);
                fileManager.exportFile(fileManager.toJson(obj.getLists()), getApplicationContext());
                obj.setLists(fileManager.jsonToString(fileManager.importFromFile(getApplicationContext())));
//                arrayAdapter.clear();
//                arrayAdapter.addAll(obj.getLists_String());
                arrayAdapter.notifyDataSetChanged();

                return true;
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListActivity.setItems(obj.getItems(position));
                ListActivity.setIndex(position);
                Log.d("grösse Items", "" + obj.getItems(position).size());
                ListActivity.setMenge(obj.getMenge());
                ListActivity.setName(obj.getLists_String().get(position));
                Intent myIntent = null;

                myIntent = new Intent(view.getContext(), ListActivity.class);
                startActivity(myIntent);
            }


        });

        setSupportActionBar(toolbar);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   public void new_list(View v){

       Intent myIntent = null;
       myIntent = new Intent(this, ListActivity.class);
       ListActivity.setIndex(-1);
       ListActivity.reset();
       startActivity(myIntent);
   }




}
