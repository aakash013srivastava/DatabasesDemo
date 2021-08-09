package com.example.databasesdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE myemployee (sno INTEGER PRIMARY KEY,name TEXT,increment TEXT)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = "DROP TABLE IF EXISTS";
        sqLiteDatabase.execSQL(drop,new String[]{"myemployee"});
        onCreate(sqLiteDatabase);

    }

    public void addEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name" ,emp.getName());
        values.put("increment" ,emp.getIncrement());
        long k = db.insert("myemployee",null,values);
        Log.d("mytag" , Long.toString(k));
        db.close();

    }
    public void getEmployee(int sno){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("myemployee" ,new String[]{"sno" , "name" ,"increment"},
                "sno=?" ,new String[]{String.valueOf(sno)},null,null,null);
        if(c != null && c.moveToFirst()){
            Log.d("getmytag" ,c.getString(1));
            Log.d("getmytag" ,c.getString(2));
        }else{
            Log.d("errormytag" , "Some error occurred");
        }
    }


    public void updateEmployee(int sno){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("name","Lebron");
        val.put("increment",12.5);
        db.update("myemployee",val,"sno=?",new String[]{String.valueOf(sno)});
    }

    public void deleteEmployee(int sno){
        SQLiteDatabase db = this.getWritableDatabase();
        int k = db.delete("myemployee","sno"+"=?",new String[]{String.valueOf(sno)});
        if(k>0){
            Log.d("deltag","Deleted");
        }else{
            Log.d("fdeltag","Delete failed");
        }

    }

}
