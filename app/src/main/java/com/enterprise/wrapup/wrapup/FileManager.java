package com.enterprise.wrapup.wrapup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;

/**
 * Created by admin on 22.09.2016.
 */
public class FileManager extends Activity{
    private static String fileName="values.txt";

    public String ToJson(ArrayList<List> lists){
        String json = new Gson().toJson(lists);
        return json;
    }

    public void exportFile(String json){
        try {
            FileOutputStream file = openFileOutput(this.fileName, Context.MODE_PRIVATE);
            file.write(json.getBytes());
            file.close();
        }catch (IOException ex){
            //Errorausgabe
        }
    }

    public void importFromFilet(){

    }
}
