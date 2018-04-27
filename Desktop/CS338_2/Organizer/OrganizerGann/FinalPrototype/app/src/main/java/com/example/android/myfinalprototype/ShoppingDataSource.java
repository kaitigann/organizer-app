package com.example.android.myfinalprototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

/* This class provides all the methods useful for interacting with this class's specific
 * Database needs.
 *
 *
 * Created by Kaitlin on 2/19/2018.
 */

public class ShoppingDataSource {
    OrganizerDBHelper mShoppingDBHelper;
    SQLiteDatabase mSQLiteDatabase;
    Context mContext;

    /**
     * Constructor
     * Initializes the context and DatabaseHelper
     *
     * @param context - Context passed in
     */

    public ShoppingDataSource(Context context) {
        mContext = context;
        mShoppingDBHelper = new OrganizerDBHelper(mContext);
    }

    /**
     * Opens the database
     */

    public void open() {
        mSQLiteDatabase = mShoppingDBHelper.getWritableDatabase();

    }

    /**
     * Closes the database
     */

    public void close() {
        if (mSQLiteDatabase != null && mSQLiteDatabase.isOpen()) {
            mShoppingDBHelper.close();
        }
    }

    /**
     * This method inserts a new item into the table
     *
     * @param listEntry A new ShoppingListEntry object
     */

    public void insertItem(ShoppingListEntry listEntry) {

        ContentValues values = new ContentValues();
        values.put(ShoppingContract.ShoppingEntry.COLUMN_ITEM, listEntry.getItem());

        long insertId = mSQLiteDatabase.insert(ShoppingContract.ShoppingEntry.SHOPPING_TABLE,
                null, values);
        if (insertId != -1) {
            listEntry.setId(insertId);
        }
    }

    /**
     * This method finds all the data, inserts it in a List, and returns the List object
     *
     * @return - The list containing all the items
     */

    public List<String> retrieveAll() {
        List<String> itemList = new ArrayList<>();

        SQLiteDatabase mReadableDatabase = mShoppingDBHelper.getReadableDatabase();

        Cursor cursor = mReadableDatabase.rawQuery("SELECT * FROM "
               + ShoppingContract.ShoppingEntry.SHOPPING_TABLE, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            itemList.add(cursor.getString(cursor.getColumnIndex(ShoppingContract.ShoppingEntry.COLUMN_ITEM)));
            cursor.moveToNext();
        }

        return itemList;
    }


    /**
     * This method deletes a single item from the table
     *
     * @param item - The item to be deleted
     */

    public void deleteItem(String item) {
        mSQLiteDatabase.execSQL("DELETE FROM " + ShoppingContract.ShoppingEntry.SHOPPING_TABLE
                + " WHERE " + ShoppingContract.ShoppingEntry.COLUMN_ITEM + " = '" + item + "'");
    }

}

