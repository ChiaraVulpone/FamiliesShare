package com.example.famshare.DataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Data.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(email TEXT primary key, name TEXT, surname TEXT, number TEXT, psw TEXT)");
        DB.execSQL("create Table Padetails(name TEXT primary key, descr TEXT, age TEXT, emailc TEXT)");
        DB.execSQL("create Table RIdetails(title TEXT primary key, emailr TEXT, date TXT,  descr TEXT, emailc TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
        DB.execSQL("drop Table if exists Padetails");
        DB.execSQL("drop Table if exists RIdetails");

    }

    public Boolean insertuserdata(String email, String number, String name, String surname, String psw)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("surname", surname);
        contentValues.put("number", number);
        contentValues.put("psw", psw);
        long result = DB.insert("Userdetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    public Boolean insertpadata(String name, String descr, String age, String emailc)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("descr", descr);
        contentValues.put("age", age);
        contentValues.put("emailc", emailc);
        long result = DB.insert("Padetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }


    public Boolean insertreqdata( String title, String emailr, String descr ,String date, String emailc )
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("emailr", emailr);
        contentValues.put("descr", descr);
        contentValues.put("date", date);
        contentValues.put("emailc", emailc);
        long result = DB.insert("RIdetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }




    public Boolean checkuseremail(String emailuser){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Userdetails where email =? ", new String[]{emailuser});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkpaname(String namesurpa){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Padetails where name =? ", new String[]{namesurpa});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkuseremailpsw(String email,String psw){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Userdetails where email =? and psw=?", new String[]{email,psw});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public Cursor getdata(String emailx)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Userdetails where email =?", new String[]{emailx});
        return cursor;
    }



    public Cursor getdataPaOnID(String EC,String NM)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Padetails where emailc =? and name=?", new String[]{EC,NM});
        return cursor;
    }

    public Cursor getdataMyReqOnID(String email,String T)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from RIdetails where emailr =? and title=?", new String[]{email,T});
        return cursor;
    }

    public Cursor getdataPa(String EC)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Padetails where emailc =? ", new String[]{EC});
        return cursor;
    }


    public Cursor getdataInc(String email)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from RIdetails where emailc =? and emailr <>? ", new String[]{email,email});
        return cursor;
    }


    public Cursor getdataMyReq(String email)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from RIdetails where emailc =? and emailr =? ", new String[]{email,email});
        return cursor;
    }

    public Cursor getdataReq(String email)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from RIdetails where emailr <>? and emailr=emailc ", new String[]{email});
        return cursor;
    }



    public Boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    // delete PA
    public Boolean deletepa(String name,String careT)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Padetails where name = ? and emailc = ?", new String[]{name,careT});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Padetails", "name=? and emailc=?", new String[]{name,careT});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    // delete account
    public Boolean deleteuseraccount(String email)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where email = ?", new String[]{email});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Userdetails", "email=?", new String[]{email});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    // delete incarico
    public Boolean deletetask(String title)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from RIdetails where title = ?", new String[]{title});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("RIdetails", "title=?", new String[]{title});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public Boolean modifyCarry(String title,String NewCarry){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emailc", NewCarry);

        long result = DB.update("RIdetails", contentValues,"title=?",new String[]{title});
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

}