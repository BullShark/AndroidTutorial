package ch.expectusafterlun.androidtutorial;

import android.content.ContentValues;
import android.content.Context;
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
        String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_HOTNESS };
        return "";
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
