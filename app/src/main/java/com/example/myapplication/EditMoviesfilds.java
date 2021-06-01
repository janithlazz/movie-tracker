package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class EditMoviesfilds extends AppCompatActivity {
    DBhelper db;
    EditText Title_edittext, year_edittext, director_edittext, cast_edittext, review_edittext;
    String title;
    RatingBar rating_edittext;
    Button btnUpdate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_movie_fild);
        Title_edittext = findViewById(R.id.Title_edittext);
        year_edittext = findViewById(R.id.year_edittext);
        director_edittext = findViewById(R.id.director_edittext);
        cast_edittext = findViewById(R.id.cast_edittext);
        review_edittext = findViewById(R.id.review_edittext);
        rating_edittext = findViewById(R.id.rating_edittext);
        btnUpdate = findViewById(R.id.btnUpdate);

        db = new DBhelper(this);

        Intent intent = getIntent();
        if (intent.hasExtra("filmName")){
            title = intent.getExtras().getString("filmName"); //get the username come from strUsername by intent
            Title_edittext.setText(title); //set the string on tvUsername what come from strUsername

            ValueHolder.allFilmDataArrayList = db.getSingleFilm(title);

            Film_data film_data = ValueHolder.allFilmDataArrayList.get(0);
            year_edittext.setText(film_data.getYEAR());
            director_edittext.setText(film_data.getDIRECTOR());
            cast_edittext.setText(film_data.getCASTING());
            review_edittext.setText(film_data.getREVIEW());
            rating_edittext.setRating(Float.parseFloat(film_data.getRATING()));
        }
        else{
            Title_edittext.setText("undefind");
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueHolder.allFilmDataArrayList = db.getSingleFilm(title);
                Film_data film_data = ValueHolder.allFilmDataArrayList.get(0);

                film_data.setYEAR(year_edittext.getText().toString());
                film_data.setDIRECTOR(director_edittext.getText().toString());
                film_data.setCASTING(cast_edittext.getText().toString());
                film_data.setREVIEW(review_edittext.getText().toString());
                film_data.setRATING(rating_edittext.getRating()+"");
                db.updateEditData(film_data);
            }
        });
}
}
