package com.example.android.myfinalprototype;

import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * These classes serve as a contract for the ShoppingListActivity and Database.
 * Created by Kaitlin on 2/19/2018.
 */

public final class ShoppingContract {

    public static abstract class ShoppingEntry implements BaseColumns{

        public static final String SHOPPING_TABLE = "shopping_list";
        public static final String ID_FIELD  = "_id";
        public static final String COLUMN_ITEM = "item";
    }
}
