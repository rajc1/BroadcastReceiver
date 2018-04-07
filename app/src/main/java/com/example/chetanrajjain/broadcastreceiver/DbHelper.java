package com.example.chetanrajjain.broadcastreceiver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by chetanrajjain on 3/24/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "NumberDB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE = "create table "+DBcontract.TABLE_NAME+ "(id integer primary key,"+
            DBcontract.INCOMING_NUMBER+" text);";
    private static final String DROP_TABLE = "drop table if exists "+DBcontract.TABLE_NAME;

    public DbHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE);

        onCreate(sqLiteDatabase);

    }


    public void saveNumber(String number,SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBcontract.INCOMING_NUMBER,number);

        sqLiteDatabase.insert(DBcontract.TABLE_NAME,null,contentValues);



    }


    public Cursor readNumber(SQLiteDatabase database){

        String[] projections = {"id",DBcontract.INCOMING_NUMBER};



       return( database.query(DBcontract.TABLE_NAME, projections,null,null,null,null,null));

    }
}
