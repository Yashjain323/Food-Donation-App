package com.yash.fooddonationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbClass {
    private SQLiteDatabase db;
    /*
 Next we have a public static final string for
 each row/table that we need to refer to both
 inside and outside this class
 */
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_ADDRESS = "address";
    public static final String TABLE_ROW_DESC = "description";
    public static final String TABLE_ROW_PHONE = "phone";
    //name VARCHAR, address VARCHAR, description VARCHAR,phone INT(10))
    /*
    Next we have a private static final strings for
    each row/table that we need to refer to just
    inside this class
    */
    private static final String DB_NAME = "food_donation_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "reciepient_info";

    public DbClass(Context context) {
        // Create an instance of our internal
        //CustomSQLiteOpenHelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        // Get a writable database
        db = helper.getWritableDatabase();
    }

    // Insert a record
    public void insert(String name, String address, String desc, String phone) {
        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" + TABLE_ROW_NAME + ", " +
                TABLE_ROW_ADDRESS + "," + TABLE_ROW_DESC + ","+ TABLE_ROW_PHONE +") " +
                "VALUES (" + "'" + name + "'" + ", " + "'" + address + "'" + "," + "'" + desc + "'" + ", " + "'" + phone + "'"+ "); ";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }

    public void delete(String name) {
        // Delete the details from the table if already exists
        String query = "DELETE FROM " + TABLE_N_AND_A + " WHERE " + TABLE_ROW_NAME + " = '" + name + "';";
        Log.i("delete() = ", query);
        db.execSQL(query);
    }

    // Get all the records
    public Cursor selectAll() {
        Cursor c = db.rawQuery("SELECT *" + " from " +
                TABLE_N_AND_A, null);
        return c;
    }

    // Find a specific record
    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_ADDRESS +"," +
                TABLE_ROW_DESC+","+TABLE_ROW_PHONE+
                " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";
        Log.i("searchName() = ", query);
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    // This class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DbClass.DB_NAME, null, DB_VERSION);
        }

        // This method only runs the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a table for photos and all their details
            String newTableQueryString = "create table "
                    + DbClass.TABLE_N_AND_A + " ("
                    + DbClass.TABLE_ROW_ID + " integer primary key autoincrement not null,"
                    + DbClass.TABLE_ROW_NAME
                    + " text not null,"
                    + DbClass.TABLE_ROW_ADDRESS
                    + " text not null,"
                    +DbClass.TABLE_ROW_DESC +"text,"
                    +DbClass.TABLE_ROW_PHONE +"text);";
            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}