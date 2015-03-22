package com.example.ruben.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Ruben on 17/3/15.
 */
public class DBProxy extends SQLiteOpenHelper {

    final public static String DB_NAME = "Notes.db";
    final public static int DB_VERSION= 1;

    final public static String DB_TABLE_NAME = "Notes";
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

    public void AddNote (String title, String body ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.putNull(DB_COL_ID);
        values.put(DB_COL_TITLE, title);
        values.put(DB_COL_NOTE, body);
        db.insert(DB_TABLE_NAME, null, values);

    }

    public Cursor ReadNotes() {

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {DB_COL_ID, DB_COL_TITLE, DB_COL_NOTE};
        return db.query(DB_TABLE_NAME, columns, null, null, null, null, null);

    }

    public void updateNote(long id, String title, String body)
    {
        SQLiteDatabase db = getWritableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(DB_COL_TITLE, title);
        values.put(DB_COL_NOTE, body);

// Which row to update, based on the ID
        String selection = DB_COL_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(id) };

        int count = db.update(
                DB_TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

}
