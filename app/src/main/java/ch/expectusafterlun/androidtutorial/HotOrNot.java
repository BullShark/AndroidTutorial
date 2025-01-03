package ch.expectusafterlun.androidtutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {

    /*
     * Gives us the row id
     * Everytime we put something in the db,
     * it's going to create a row starting at
     * 1, the next time we enter something into the db,
     * row 2, row 3, and this is a way to reference that
     */
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOTNESS = "persons_hotness";

    private static final String DATABASE_NAME = "hotornotdb";
    /*
     * A table will hold rowid, name, hotness from above
     */
    private static final String DATABASE_TABLE = "people_table";
    private static final int DATABASE_VERSION = 1;

    private DbHelper helper;
    private final Context context;
    private SQLiteDatabase db;

    final String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_HOTNESS };

    public HotOrNot(Context context) {
        this.context = context;
    }

    public HotOrNot open() throws SQLException {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();

        return this;
    }

    public void close() {
        helper.close();
    }

    public long createEntry(String name, String hotness) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_HOTNESS, hotness);
        return db.insert(DATABASE_TABLE, null, cv);
    }

    public String getData() {
        Cursor cursor = db.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";
        int iRow = cursor.getColumnIndex(KEY_ROWID);
        int iName = cursor.getColumnIndex(KEY_NAME);
        int iHotness = cursor.getColumnIndex(KEY_HOTNESS);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            result = result + cursor.getString(iRow) + " " + cursor.getString(iName) + " " + cursor.getString(iHotness) + '\n';
        }

        return result;
    }

    public String getName(long l) throws SQLException {
        Cursor cursor = db.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            String str = cursor.getString(1); // Name column at position 1
            cursor.close();
            return str;
        } else {
            return null;
        }
    }

    public String getHotness(long l) throws SQLException {
        Cursor cursor = db.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            String str = cursor.getString(2); // Hotness column at position 2
            cursor.close();
            return str;
        } else {
            return null;
        }
    }

    public void updateEntry(long lRow, String mName, String mHotness) throws SQLException {
        ContentValues cvUpdate = new ContentValues();
        cvUpdate.put(KEY_NAME, mName);
        cvUpdate.put(KEY_HOTNESS, mHotness);
        db.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);
    }

    public void deleteEntry(long lRow2) throws SQLException {
        db.delete(DATABASE_TABLE, KEY_ROWID + "=" + lRow2, null);
    }

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /*
         * The first time we ever create a db is the only time
         * this onCreate() method is going to be called.
         * After that, it's going to call the onUpgrade() method.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " " + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_HOTNESS + " TEXT NOT NULL);"
            );
        }

        /*
         * If our db has already been created, this will be called instead of onCreate().
         * What this does is if the table exist, we are going to drop it and call onCreate().
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
}
