package androidword.example.com.androiddzy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScoreModel {
    private SQLiteDatabase mDatabase;
    private final SqliteOpenHelper mDbHelper;

    public static final String TABLE_NAME = "score";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SCORE = "score";

    public ScoreModel(Context context) {
        mDbHelper = new SqliteOpenHelper(context);
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public Cursor getAllScores() {
        return mDatabase.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_SCORE}, null, null, null, null, null);
    }

    public long addScore(int score) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, score);
        return mDatabase.insert(TABLE_NAME, null, values);
    }

    public boolean deleteScore(long id) {
        return mDatabase.delete(TABLE_NAME, COLUMN_ID + "=" + id, null) > 0;
    }


    private static class SqliteOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "score.db";
        private static final int DATABASE_VERSION = 1;

        private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SCORE + " INTEGER NOT NULL" +
                ");";

        public SqliteOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}