//package com.example.myapplication;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.database.Cursor;
//import android.os.Bundle;
//import android.util.SparseBooleanArray;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//public class EditMovies extends AppCompatActivity {
//    DBhelper db;
//    ListView listView;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_movies);
//        db = new DBhelper(this);
//
//        ArrayList<String> theList = new ArrayList<>();
//        Cursor cursor = db.getData();
//        if(cursor.getCount() == 0){
//            Toast.makeText(EditMovies.this, "Empty",Toast.LENGTH_SHORT);
//        }else {
//            while (cursor.moveToNext()){
//                theList.add(cursor.getString(0));
//                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,theList);
//                listView.setAdapter(listAdapter);
//
//            }
//
//
//        }
//    }
//}

package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditMovies extends AppCompatActivity {

    DBhelper db;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movies);
        listView = findViewById(R.id.list_edit);

        // ListView listView =(ListView)findViewById(R.id.listView);
        db = new DBhelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor cursor = db.getData();
        if (cursor.getCount() == 0) {
            Toast.makeText(EditMovies.this, "Empty", Toast.LENGTH_SHORT);
        } else {
            while (cursor.moveToNext()) {
                theList.add(cursor.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);

            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(EditMovies.this, EditMoviesfilds.class);
                i.putExtra("filmName", listView.getAdapter().getItem(position).toString());
                startActivity(i);
            }
        });


    }
}


