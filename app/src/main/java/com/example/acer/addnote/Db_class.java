package com.example.acer.addnote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Acer on 25-03-2018.
 */
class Db_class extends SQLiteOpenHelper{
    public Db_class(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table note(_id INTEGER PRIMARY KEY AUTOINCREMENT,Title text,Description Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addnote(String Title,String Description){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("Title",Title);
        values.put("Description", Description);
        database.insert("note", null, values);
    }
    public Cursor readnote(){
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.query("note",null,null,null,null,null,null);
        cursor.moveToFirst();
        for (int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
        }
        return cursor;
    }
    Cursor readFriendById(int id){
        SQLiteDatabase database=getReadableDatabase();
        String[]arr={String.valueOf(id)};
        Cursor cursor=database.query("note",null,"_id=?",arr,null,null,null);

        return cursor;
    }
}
