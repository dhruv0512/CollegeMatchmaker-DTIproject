package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper( Context context) {
        super(context, "Login.db", null, 1);
    }

    public static final String DbName="Login.db";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users(name TEXT, gender TEXT, email TEXT, username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");

    }

    public boolean insertData(String name,String gender,String email,String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("gender", gender);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("users",null, contentValues);
        if(result==-1) return false;
        else
            return true;


    }

    public boolean checkUsername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from users where username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }


    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from users where username=? and password=?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public String getName() {

        String rv = "not found";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor csr = db.query("users",null,null,null,null,null,null);
        if (csr.moveToFirst()) {
            rv = csr.getString(csr.getColumnIndex("name"));
        }
        return rv;
    }
    public String getEmail() {

        String rv = "not found";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor csr = db.query("users",null,null,null,null,null,null);
        if (csr.moveToFirst()) {
            rv = csr.getString(csr.getColumnIndex("email"));
        }
        return rv;
    }
}
