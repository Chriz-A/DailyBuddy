package de.ur.mi.android.dailybuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.util.ArrayList;



public class NoteDatabase {

    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "notes";
    public static final String KEY_ID = "_id";
    public static final String KEY_TEXT = "text";
    public static final int COLUMN_TEXT_INDEX = 1;

    private NoteDBOpenHelper dbHelper;
    private SQLiteDatabase db;

    public NoteDatabase(Context context) {
        dbHelper = new NoteDBOpenHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public void open() throws SQLException {
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            db = dbHelper.getReadableDatabase();
        }
    }

    public void close() {
        db.close();
    }

    public long insertNote(String note) {
        ContentValues newNoteValues = new ContentValues();
        newNoteValues.put(KEY_TEXT, note);
        return db.insert(DATABASE_TABLE, null, newNoteValues);
    }

    public void removeNote(String note) {
        String deleteNote = KEY_TEXT + " = '" + note+ "'";
        db.delete(DATABASE_TABLE, deleteNote, null);
    }

    public ArrayList<String> getAllNotes() {
        ArrayList<String> notes = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE, new String[] { KEY_ID,
                KEY_TEXT }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String text = cursor.getString(COLUMN_TEXT_INDEX);
                notes.add(text);
            } while (cursor.moveToNext());
        }
        return notes;
    }


    private class NoteDBOpenHelper extends SQLiteOpenHelper {

        private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE  + " (" + KEY_ID +
                " integer primary key autoincrement, " + KEY_TEXT + " text not null);";

        public NoteDBOpenHelper(Context activity, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
            super(activity, dbname, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
