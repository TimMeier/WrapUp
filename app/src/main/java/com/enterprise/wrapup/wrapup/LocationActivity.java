package com.enterprise.wrapup.wrapup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by admin on 22.09.2016.
 */
public class LocationActivity extends Activity {

    ImageButton btn_clear_et_adress;
    EditText et_adress;
    FloatingActionButton btn_location;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_main);

        btn_clear_et_adress = (ImageButton) findViewById(R.id.btn_clear_et_adress);
        et_adress = (EditText) findViewById(R.id.et_adress);
        btn_location = (FloatingActionButton) findViewById(R.id.btn_location);

    }

    // btn_clear_et_adress Listener
    public void removeAdress(View v){
        et_adress.setText("");
    }

    public void goToMainActivity(View v){
        Intent myIntent = new Intent(LocationActivity.this, MainActivity.class);
        LocationActivity.this.startActivity(myIntent);
    }
}
