package com.mlabs.bbm.firstandroidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by androidstudio on 17/09/16.
 */
public class AccountRepo {

    private DBHelper dbHelper;

    public AccountRepo(Context context){
        dbHelper = new DBHelper(context);
    }

    public int createAccount(Account acct){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Account.KEY_email, acct.acct_email);
        values.put(Account.KEY_password, acct.acct_password);
        values.put(Account.KEY_datecreated, acct.acct_datecreated);

        long acct_Id = db.insert(Account.TABLE, null, values);
        db.close();
        return (int) acct_Id;

    }

    public void deleteAccount(int acct_Id){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Account.TABLE, Account.KEY_ID + "+ ?", new String[] {String.valueOf(acct_Id)});
        db.close();

    }

    public void updateAccount(Account acct){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Account.KEY_email, acct.acct_email);
        values.put(Account.KEY_password, acct.acct_password);
        values.put(Account.KEY_datecreated, acct.acct_datecreated);

        db.update(Account.TABLE, values, Account.KEY_ID + "= ?", new String[] {String.valueOf(acct.acct_ID)});
        db.close();

    }

    public boolean validateLogin(String email, String password){

        boolean res = false;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(Account.TABLE, new String [] {Account.KEY_email, Account.KEY_password}, Account.KEY_ID + "=?",
                new String[] {email, password}, null, null, null, null);

        if (cursor!=null){
            res = true;
        }else
        {
            res = false;
        }

        return res;

    }
    public boolean checkAccount (Account acct){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selectQuery = "SELECT " + Account.KEY_email + " FROM " + Account.TABLE + " WHERE " + Account.KEY_email + " = " + acct.acct_email;

        db.close();
        return true;

    }
}