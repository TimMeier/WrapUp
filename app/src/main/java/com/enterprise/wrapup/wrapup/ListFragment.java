//package com.enterprise.wrapup.wrapup;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//
//import java.util.ArrayList;
//
///**
// * Created by Sandro on 28.09.2016.
// */
//
//public class ListFragment extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle args) {
//        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);
//        ImageButton btn_save = (ImageButton) view.findViewById(R.id.btn_save);
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Event", "vor schreiben");
//                FileManager fileManager = new FileManager();
//                MainClass mainClass = new MainClass();
//                mainClass.mappToBackend(adapter.getItems(), adapter.getMenge(), new ArrayList<Boolean>(), et_listname.getEditableText().toString());
//                fileManager.exportFile(fileManager.toJson(mainClass.getLists()));
//
//            }
//        });
//
//        return view;
//    }
//}
