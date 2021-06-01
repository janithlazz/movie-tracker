package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterMovie extends AppCompatActivity {
    EditText  title,year,director,cast,rating,review;
    Button save;
    DBhelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_movie);
        title = findViewById(R.id.Title_edittext);
        year = findViewById(R.id.year_edittext);
        director = findViewById(R.id.director_edittext);
        cast = findViewById(R.id.cast_edittext);
        rating = findViewById(R.id.rating_edittext);
        review = findViewById(R.id.review_edittext);


        save = findViewById(R.id.save_button);



        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                db = new DBhelper(RegisterMovie.this);
                Film_data film_data = new Film_data();
                film_data.setTITLE(title.getText().toString());
                film_data.setYEAR(year.getText().toString());
                film_data.setDIRECTOR(director.getText().toString());
                film_data.setCASTING(cast.getText().toString());
                film_data.setRATING(rating.getText().toString());
                film_data.setREVIEW(review.getText().toString());
                film_data.setFEV(false);


                db.NewSaveData(film_data);

            }
        });
    }

}