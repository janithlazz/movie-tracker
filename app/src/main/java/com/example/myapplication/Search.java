package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        db = new DBhelper(this);



        final EditText editTitle_ID = (EditText)findViewById(R.id.editSearch);
        Button Lookup_btn = (Button)findViewById(R.id.btn_lookup);
        final TextView resTitle  = (TextView)findViewById(R.id.resTitle);
        final TextView resYear  = (TextView)findViewById(R.id.resYear);
        final TextView resDirector  = (TextView)findViewById(R.id.resDirector);
        final TextView resCast  = (TextView)findViewById(R.id.resCast);
        final TextView resRating  = (TextView)findViewById(R.id.resRating);
        final TextView resReview  = (TextView)findViewById(R.id.resReview);


        final TextView textTitle  = (TextView)findViewById(R.id.textTitle);
        final TextView textYear  = (TextView)findViewById(R.id.textYear);
        final TextView textDirector  = (TextView)findViewById(R.id.textDirector);
        final TextView textCast  = (TextView)findViewById(R.id.textCast);
        final TextView textRating  = (TextView)findViewById(R.id.textRating);
        final TextView textReview  = (TextView)findViewById(R.id.textReview);




        // action when search button clicked
        Lookup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleId = editTitle_ID.getText().toString();

                // access cursor data
                Cursor cursor = db.searchData(titleId);
                cursor.moveToFirst();

                // check if cursor return data or not (data found in db or not)
                if(cursor.getCount() < 1)
                {
                    // empty all result
                    resTitle.setText("");
                    resYear.setText("");
                    resDirector.setText("");
                    resCast.setText("");
                    resRating.setText("");
                    resReview.setText("");

                    // show toast message
                    Toast.makeText(getApplicationContext(), "No data found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String title = cursor.getString(cursor.getColumnIndex(DBhelper.TITLE));
                    String year = cursor.getString(cursor.getColumnIndex(DBhelper.YEAR));
                    String director = cursor.getString(cursor.getColumnIndex(DBhelper.DIRECTOR));
                    String casting = cursor.getString(cursor.getColumnIndex(DBhelper.CASTING));
                    String rating = cursor.getString(cursor.getColumnIndex(DBhelper.RATING));
                    String review = cursor.getString(cursor.getColumnIndex(DBhelper.REVIEW));


                    //invisible to text labels lookup btn click
                    textTitle.setVisibility(View.VISIBLE);
                    textYear.setVisibility(View.VISIBLE);
                    textDirector.setVisibility(View.VISIBLE);
                    textCast.setVisibility(View.VISIBLE);
                    textRating.setVisibility(View.VISIBLE);
                    textReview.setVisibility(View.VISIBLE);



                    //append all the data

                    resTitle.setText(title);
                    resYear.setText(year);
                    resDirector.setText(director);
                    resCast.setText(casting);
                    resRating.setText(rating);
                    resReview.setVisibility(View.VISIBLE);
                    resReview.setText(review);



                    // show toast message
                    Toast.makeText(getApplicationContext(), "Data found",Toast.LENGTH_SHORT).show();
                }

                // close cursor
                if (!cursor.isClosed())  {
                    cursor.close();
                }
            }
        });

    }
}
//package com.example.myapplication;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Search extends AppCompatActivity {
//    DBhelper db;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        db = new DBhelper(this);
//
//
//
//        final EditText editTitle_ID = (EditText)findViewById(R.id.editSearch);
//        Button Lookup_btn = (Button)findViewById(R.id.btn_lookup);
//        final TextView resTitle  = (TextView)findViewById(R.id.resTitle);
//        final TextView resYear  = (TextView)findViewById(R.id.resYear);
//        final TextView resDirector  = (TextView)findViewById(R.id.resDirector);
//        final TextView resCast  = (TextView)findViewById(R.id.resCast);
//        final TextView resRating  = (TextView)findViewById(R.id.resRating);
//        final TextView resReview  = (TextView)findViewById(R.id.resReview);
//
//
//        // action when search button clicked
//        Lookup_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String titleId = editTitle_ID.getText().toString();
//
//                // access cursor data
//                Cursor cursor = db.searchData(titleId);
//                cursor.moveToFirst();
//
//                // check if cursor return data or not (data found in db or not)
//                if(cursor.getCount() < 1)
//                {
//                    // empty all result
//                    resTitle.setText("");
//                    resYear.setText("");
//                    resDirector.setText("");
//                    resCast.setText("");
//                    resRating.setText("");
//                    resReview.setText("");
//
//                    // show toast message
//                    Toast.makeText(getApplicationContext(), "No data found",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    String title = cursor.getString(cursor.getColumnIndex(DBhelper.TITLE));
//                    String year = cursor.getString(cursor.getColumnIndex(DBhelper.YEAR));
//                    String director = cursor.getString(cursor.getColumnIndex(DBhelper.DIRECTOR));
//                    String casting = cursor.getString(cursor.getColumnIndex(DBhelper.CASTING));
//                    String rating = cursor.getString(cursor.getColumnIndex(DBhelper.RATING));
//                    String review = cursor.getString(cursor.getColumnIndex(DBhelper.REVIEW));
//
//                    //append all the data
//                    resTitle.setText(title);
//                    resYear.setText(year);
//                    resDirector.setText(director);
//                    resCast.setText(casting);
//                    resRating.setText(rating);
//                    resReview.setText(review);
//
//
//
//                    // show toast message
//                    Toast.makeText(getApplicationContext(), "Data found",Toast.LENGTH_SHORT).show();
//                }
//
//                // close cursor
//                if (!cursor.isClosed())  {
//                    cursor.close();
//                }
//            }
//        });
//
//    }
//}