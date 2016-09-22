package com.enterprise.wrapup.wrapup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 22.09.2016.
 */
public class ListActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
//        tv.setText("This is page 1");
        setContentView(R.layout.activity_list);
    }
}
