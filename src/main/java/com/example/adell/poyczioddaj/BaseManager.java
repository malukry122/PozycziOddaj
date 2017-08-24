package com.example.adell.poyczioddaj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class BaseManager extends SQLiteOpenHelper {

    Context con;

    public BaseManager(Context context){
        super(context, "przedmioty.db", null, 1);
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table przedmioty("+
        "id integer primary key autoincrement,"+
        "nazwa text,"+
        "ilosc integer,"+
        "data_do text,"+
        "uwagi text);"+
        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void addItem(String nazwa, Integer ilosc, String data_do, String uwagi){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa",nazwa);
        wartosci.put("ilosc",ilosc);
        wartosci.put("data_do",data_do);
        wartosci.put("uwagi",uwagi);
        db.insertOrThrow("przedmioty", null, wartosci);


        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(con, text, duration);
        toast.show();
    }

    public Cursor getAllItems() {
        String[] kolumny={"id","nazwa","ilosc","data_do","uwagi"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("przedmioty",kolumny, null, null, null, null, null);
        return kursor;
    }
}
