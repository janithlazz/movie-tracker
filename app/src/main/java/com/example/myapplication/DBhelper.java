
package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Rating;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Userdata.db";
    public static final String TABLE_NAME = "saveDetails";
    public static final String TITLE = "title";
    public static final String YEAR = "year";
    public static final String DIRECTOR = "director";
    public static final String CASTING = "casting";
    public static final String RATING = "rating";
    public static final String REVIEW = "review";
    public static final String FEV = "fev";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME +
                        " (" + TITLE + " text primary key, "
                        + YEAR + " text,"
                        + DIRECTOR + " text,"
                        + CASTING + " text,"
                        + RATING + " text,"
                        + REVIEW + " text,"
                        + FEV + " boolean)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists " + TABLE_NAME);
    }

    public void NewSaveData(Film_data film_data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", film_data.getTITLE());
        contentValues.put("year", film_data.getYEAR());
        contentValues.put("director", film_data.getDIRECTOR());
        contentValues.put("casting", film_data.getCASTING());
        contentValues.put("rating", film_data.getRATING());
        contentValues.put("review", film_data.getREVIEW());
        contentValues.put("fev", film_data.isFEV());

        db.insert("saveDetails", null, contentValues);


    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from saveDetails", null);
        return cursor;

    }

    public void updateIsChecked(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("value", 0);
        db.update("table", newValues, "id =? ", new String[]{id});
        db.close();
    }

    public Cursor searchData(String searchInput) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where title = '" + searchInput +
                "' or year LIKE '%" + searchInput + "%'", null);
        return cursor;
    }

    public void updateFavData(Film_data filmData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put(FEV, filmData.isFEV());
        db.update(TABLE_NAME, newValues, TITLE + " = ? ", new String[]{filmData.getTITLE()});
        db.close();
    }


//-

    public List<Film_data> getAllFilms() {
        List<Film_data> film_dataList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;         // Select All Query

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {         // looping through all rows and adding to list
            do {
                Film_data film_data1 = new Film_data();
                film_data1.setTITLE(cursor.getString(cursor.getColumnIndex(TITLE)));
                film_data1.setYEAR(cursor.getString(cursor.getColumnIndex(YEAR)));
                film_data1.setDIRECTOR(cursor.getString(cursor.getColumnIndex(DIRECTOR)));
                film_data1.setCASTING(cursor.getString(cursor.getColumnIndex(CASTING)));
                film_data1.setRATING(cursor.getString(cursor.getColumnIndex(RATING)));
                film_data1.setREVIEW(cursor.getString(cursor.getColumnIndex(REVIEW)));
                boolean value = cursor.getInt(cursor.getInt(cursor.getColumnIndex(FEV))) > 0;
                film_data1.setFEV(value);
                film_dataList.add(film_data1);
            } while (cursor.moveToNext());
        }

        db.close();     // close db connection
        return film_dataList;    // return all films list
    }

    public List<Film_data> getFavFilms() {
        List<Film_data> film_dataList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " where fev = 1";         // Select all fav Query

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {         // looping through all rows and adding to list
            do {
                Film_data film_data1 = new Film_data();
                film_data1.setTITLE(cursor.getString(cursor.getColumnIndex(TITLE)));
                film_data1.setYEAR(cursor.getString(cursor.getColumnIndex(YEAR)));
                film_data1.setDIRECTOR(cursor.getString(cursor.getColumnIndex(DIRECTOR)));
                film_data1.setCASTING(cursor.getString(cursor.getColumnIndex(CASTING)));
                film_data1.setRATING(cursor.getString(cursor.getColumnIndex(RATING)));
                film_data1.setREVIEW(cursor.getString(cursor.getColumnIndex(REVIEW)));
                boolean value = cursor.getInt(cursor.getInt(cursor.getColumnIndex(FEV))) > 0;
                film_data1.setFEV(value);
                film_dataList.add(film_data1);
            } while (cursor.moveToNext());
        }

        db.close();     // close db connection
        return film_dataList;    // return all films list
    }

    public List<Film_data> getNoneFavFilms() {
        List<Film_data> film_dataList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " where fev != 1";         // Select all fav Query

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {         // looping through all rows and adding to list
            do {
                Film_data film_data1 = new Film_data();
                film_data1.setTITLE(cursor.getString(cursor.getColumnIndex(TITLE)));
                film_data1.setYEAR(cursor.getString(cursor.getColumnIndex(YEAR)));
                film_data1.setDIRECTOR(cursor.getString(cursor.getColumnIndex(DIRECTOR)));
                film_data1.setCASTING(cursor.getString(cursor.getColumnIndex(CASTING)));
                film_data1.setRATING(cursor.getString(cursor.getColumnIndex(RATING)));
                film_data1.setREVIEW(cursor.getString(cursor.getColumnIndex(REVIEW)));
                boolean value = cursor.getInt(cursor.getInt(cursor.getColumnIndex(FEV))) > 0;
                film_data1.setFEV(value);

                film_dataList.add(film_data1);
            } while (cursor.moveToNext());
        }
        db.close();     // close db connection

        return film_dataList;    // return all films list
    }

    public List<Film_data> getSingleFilm(String filmTitle) {
        List<Film_data> film_dataList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from saveDetails where title LIKE '%' || ? || '%'", new String[]{filmTitle});

        if (cursor.moveToFirst()) {         // looping through all rows and adding to list
            do {
                Film_data film_data1 = new Film_data();
                film_data1.setTITLE(cursor.getString(cursor.getColumnIndex(TITLE)));
                film_data1.setYEAR(cursor.getString(cursor.getColumnIndex(YEAR)));
                film_data1.setDIRECTOR(cursor.getString(cursor.getColumnIndex(DIRECTOR)));
                film_data1.setCASTING(cursor.getString(cursor.getColumnIndex(CASTING)));
                film_data1.setRATING(cursor.getString(cursor.getColumnIndex(RATING)));
                film_data1.setREVIEW(cursor.getString(cursor.getColumnIndex(REVIEW)));
                boolean value = cursor.getInt(cursor.getInt(cursor.getColumnIndex(FEV))) > 0;
                film_data1.setFEV(value);
                film_dataList.add(film_data1);
            } while (cursor.moveToNext());
        }
        db.close();     // close db connection

        return film_dataList;    // return all films list
    }

    public void updateEditData(Film_data filmData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put(TITLE, filmData.getTITLE());
        newValues.put(YEAR, filmData.getYEAR());
        newValues.put(DIRECTOR, filmData.getDIRECTOR());
        newValues.put(CASTING, filmData.getCASTING());
        newValues.put(RATING, filmData.getRATING());
        newValues.put(REVIEW, filmData.getREVIEW());

        db.update(TABLE_NAME, newValues, TITLE + " = ? ", new String[]{filmData.getTITLE()});
        db.close();
    }

}
