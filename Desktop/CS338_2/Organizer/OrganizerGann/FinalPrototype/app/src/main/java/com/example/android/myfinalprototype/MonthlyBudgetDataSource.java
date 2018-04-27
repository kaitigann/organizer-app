package com.example.android.myfinalprototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

/*
 * This class provides all the methods useful for interacting with this class's specific
 * Database needs.
 * Created by Kaitlin on 2/20/2018.
 */

public class MonthlyBudgetDataSource {
    OrganizerDBHelper mBudgetDBHelper;
    SQLiteDatabase mWriteableDatabase;

    Context mContext;

    /**
     * Constructor
     * Initializes the context and DatabaseHelper
     * @param context - Context passed in
     */

    public MonthlyBudgetDataSource(Context context) {
        mContext = context;
        mBudgetDBHelper = new OrganizerDBHelper(mContext);
    }

    /**
     * Opens the database
     */

    public void open(){
        mWriteableDatabase = mBudgetDBHelper.getWritableDatabase();
    }

    /**
     * Closes the database
     */

    public void close(){
        if(mWriteableDatabase != null && mWriteableDatabase.isOpen() ){
            mBudgetDBHelper.close();
        }
    }

    /**
     * This method inserts a new budget into the table
     *
     * @param budgetEntry - A new MonthlyBudgetEntry object
     */

    public void insertBudget(MonthlyBudgetEntry budgetEntry){

        ContentValues values = new ContentValues();
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_INCOME1, budgetEntry.getIncomeAmt1());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_INCOME2, budgetEntry.getIncomeAmt2());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_INCOME1,budgetEntry.getIncomeName1() );
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_INCOME2,budgetEntry.getIncomeName2());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED1, budgetEntry.getFixedAmt1());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED2, budgetEntry.getFixedAmt2());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED3, budgetEntry.getFixedAmt3());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED4, budgetEntry.getFixedAmt4());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED5, budgetEntry.getFixedAmt5());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED6, budgetEntry.getFixedAmt6());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_FIXED7, budgetEntry.getFixedAmt7());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED1, budgetEntry.getFixedName1());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED2, budgetEntry.getFixedName2());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED3, budgetEntry.getFixedName3());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED4, budgetEntry.getFixedName4());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED5, budgetEntry.getFixedName5());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED6, budgetEntry.getFixedName6());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_FIXED7, budgetEntry.getFixedName7());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE1, budgetEntry.getVariableAmt1());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE2, budgetEntry.getVariableAmt2());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE3, budgetEntry.getVariableAmt3());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE4, budgetEntry.getVariableAmt4());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE5, budgetEntry.getVariableAmt5());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE6, budgetEntry.getVariableAmt6());
        values.put(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE7, budgetEntry.getVariableAmt7());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE1, budgetEntry.getVariableName1());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE2, budgetEntry.getVariableName2());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE3, budgetEntry.getVariableName3());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE4, budgetEntry.getVariableName4());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE5, budgetEntry.getVariableName5());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE6, budgetEntry.getVariableName6());
        values.put(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE7, budgetEntry.getVariableName7());

        long insertId = mWriteableDatabase.insert(MonthlyBudgetContract.BudgetEntry.BUDGET_TABLE,
                null, values);
        if(insertId != -1){
            budgetEntry.setId(insertId);
        }
    }

    /**
     * This method returns a list containing the values for a budget entry.
     */

    public List<String> getBudgetList(){

        List<String> budgetList = new ArrayList<>();
        SQLiteDatabase mReadableDatabase = mBudgetDBHelper.getReadableDatabase();

        Cursor cursor = mReadableDatabase.rawQuery("SELECT * FROM "
                + MonthlyBudgetContract.BudgetEntry.BUDGET_TABLE, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_INCOME1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_INCOME2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_INCOME1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_INCOME2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED3)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED4)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED5)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED6)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_FIXED7)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED3)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED4)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED5)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED6)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_FIXED7)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE3)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE4)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE5)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE6)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE7)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE1)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE2)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE3)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE4)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE5)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE6)));
            budgetList.add(cursor.getString(cursor.getColumnIndex(MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE7)));
            cursor.moveToNext();
        }
        return budgetList;
    }

    /**
     * This method deletes all the items in the table
     */
    public void deleteAll(){
        mWriteableDatabase.delete(MonthlyBudgetContract.BudgetEntry.BUDGET_TABLE,
                null, null);
    }
}
