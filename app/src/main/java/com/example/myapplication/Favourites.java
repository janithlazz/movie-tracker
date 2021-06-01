package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Favourites extends AppCompatActivity {
    private ListView lvFav;
    DBhelper db;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        lvFav = findViewById(R.id.lvFav);
        btnUpdate = findViewById(R.id.btnUpdate);
        db = new DBhelper(this);

        ArrayList<String> theList = new ArrayList<>();
        ValueHolder.favFilmDataArrayList = db.getFavFilms();

        if (ValueHolder.favFilmDataArrayList.size() < 1) {
            Toast.makeText(Favourites.this, "Empty", Toast.LENGTH_SHORT);
        } else {
            for (int i = 0; i < ValueHolder.favFilmDataArrayList.size(); i++) {
                theList.add(ValueHolder.favFilmDataArrayList.get(i).getTITLE());
            }
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, theList);
            lvFav.setAdapter(listAdapter);

            for(int i=0; i<theList.size(); i++){
                lvFav.setItemChecked(i,true);
            }
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedArray = lvFav.getCheckedItemPositions();
                Log.e("chk item position", checkedArray + "");

                for (int i = 0; i < ValueHolder.favFilmDataArrayList.size(); i++) {
                    Log.e("chk bool", " " + i + " state: " + checkedArray.get(i));

                    if (checkedArray.get(i)) {
                        Film_data film_data = ValueHolder.favFilmDataArrayList.get(i);
                        film_data.setFEV(true);
                        db.updateFavData(film_data);
                    }
                    else {
                        Film_data film_data = ValueHolder.favFilmDataArrayList.get(i);
                        film_data.setFEV(false);
                        db.updateFavData(film_data);
                    }
                }

                Intent intent = new Intent(Favourites.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}