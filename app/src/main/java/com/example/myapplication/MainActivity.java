package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    //Add a variables for buttons
    ImageButton display, register, favourites, edit , search , rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the register button
        register = (ImageButton) findViewById(R.id.reg_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {Regbtn();}
        });

        //Set display button id
        display = (ImageButton)findViewById(R.id.display_btn);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayMovies.class);
                startActivity(intent);

            }
        });

        favourites = (ImageButton)findViewById(R.id.fev_btn);
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favouritebtn();

            }
        });

        edit = (ImageButton)findViewById(R.id.edit_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editbtn();
            }
        });

        search = (ImageButton)findViewById(R.id.search_btn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Searchbtn();
            }
        });

        rating = (ImageButton)findViewById(R.id.ratings_btn);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ratingbutton();
            }
        });

    }
    //Open Ratings movie class
    private void Ratingbutton() {
        Intent intent = new Intent(this,Ratings.class);
        startActivity(intent);
    }
    //Open Search movie class
    private void Searchbtn() {
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }
    // Open Edit movie class
    private void Editbtn() {
        Intent intent = new Intent(this,EditMovies.class);
        startActivity(intent);
    }
    // Open Favourites class
    private void Favouritebtn() {
        Intent intent = new Intent(this,Favourites.class);
        startActivity(intent);
    }


    // Open Register movie class
    private void Regbtn() {
        Intent intent = new Intent(this, RegisterMovie.class);
        startActivity(intent);
    }

}