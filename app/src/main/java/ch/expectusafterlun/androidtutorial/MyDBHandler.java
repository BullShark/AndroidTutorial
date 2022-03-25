package ch.expectusafterlun.androidtutorial;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT" +
                ");";
        db.execSQL(query);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    // Add a new row to the database
    public void addProduct(Products products) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, products.get_productname());
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "= \"" + productName + "\";");
        db.close();
    }

    // Print out the database as a String
    @SuppressLint("Range")
    public String toString() {
        SQLiteDatabase db = getWritableDatabase();
        String dbString = "";
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1=1;";
        // Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        // Move to the first row
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME)) + '\n';
            }
        }
        db.close();

        return dbString;
    }
}
