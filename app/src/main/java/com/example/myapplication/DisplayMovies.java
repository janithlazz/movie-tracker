package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMovies extends AppCompatActivity {

    DBhelper db;
    ListView listView;
    Button addFav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);
        listView = findViewById(R.id.listView);
        addFav = findViewById(R.id.fav_bn);
        // ListView listView =(ListView)findViewById(R.id.listView);
        db = new DBhelper(this);

        ArrayList<String> theList = new ArrayList<>();

        ValueHolder.filmDataArrayList = db.getNoneFavFilms();

        if (ValueHolder.filmDataArrayList.size() < 1) {
            Toast.makeText(DisplayMovies.this, "Empty", Toast.LENGTH_SHORT);
        } else {
            for (int i = 0; i < ValueHolder.filmDataArrayList.size(); i++) {
                theList.add(ValueHolder.filmDataArrayList.get(i).getTITLE());
            }

            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, theList);
            listView.setAdapter(listAdapter);
        }

        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedArray = listView.getCheckedItemPositions(); // get checked items integer array. (Selected items has 1 & 0 s). Like: {0=false, 1=true, 2=false}
                Log.e("chk item position", checkedArray + ""); //console log for check array.

                for (int i = 0; i < ValueHolder.filmDataArrayList.size(); i++) { // iterate through filmsDataArray List items. 0 to last item
                    Log.e("chk bool", " " + i + " state: " + checkedArray.get(i)); //console log for check specific position.
                    if (checkedArray.get(i)) { //
                        Film_data film_data = ValueHolder.filmDataArrayList.get(i);
                        film_data.setFEV(true);
                        db.updateFavData(film_data);
                    }
                    else {
                        Film_data film_data = ValueHolder.filmDataArrayList.get(i);
                        film_data.setFEV(false);
                        db.updateFavData(film_data);
                    }
                }

                Intent intent = new Intent(DisplayMovies.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}