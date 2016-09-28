package com.enterprise.wrapup.wrapup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;

/**
 * Created by admin on 22.09.2016.
 */
public class FileManager{
    private static String fileName="values.txt";

    public String toJson(ArrayList<List> lists){
        String json = new Gson().toJson(lists);
        return json;
    }

    public ArrayList<List> jsonToString(String json){
        Gson gson = new Gson();
        ArrayList<List> lists = gson.fromJson(json, ArrayList.class);
        return lists;
    }

    public boolean exportFile(String json, Context context){
        try {
            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }

            OutputStreamWriter  file = new OutputStreamWriter(context.openFileOutput(this.fileName, Context.MODE_PRIVATE));
            file.write(json);
            file.close();
            return true;
        }catch (IOException ex){
            Log.d("Fehler",  "" + ex);
            return false;
        }
    }

    public String importFromFile(Context context){
        try {
            FileInputStream inputFile = context.openFileInput(this.fileName);
            java.util.List<Byte> data = new ArrayList<Byte>();
            while(true){
                int b = inputFile.read();

                if (b == -1){
                    break;
                }else{
                    data.add((byte)b);
                }
            }
            byte[] bytes = new byte[data.size()];

            for(int i = 0; i < bytes.length; i++){
                bytes[i] = data.get(i);
            }

            String json = new String(bytes);
            Log.d("Meine App", json);

            return json;
        }catch(IOException ex){
            Log.d("meineApp", ex.getMessage());
            return ex.getMessage();
        }

    }
}
