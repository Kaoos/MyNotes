package com.example.ruben.mynotes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Ruben on 17/3/15.
 */
public class DBProxy extends SQLiteOpenHelper {

    final public static String DB_NAME = "Notes.db";
    final public static int DB_VERSION= 1;

    final public static String DB_TABLE_NAME = "Notes.db";
    final public static String DB_COL_ID = BaseColumns._ID;
    final public static String DB_COL_TITLE = "title" ;
    final public static String DB_COL_NOTE = "note";

    public DBProxy(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+DB_TABLE_NAME+"("+DB_COL_ID+" INTEGER PRIMARY KEY,"+DB_COL_TITLE+" TEXT,"+ DB_COL_NOTE+" TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
