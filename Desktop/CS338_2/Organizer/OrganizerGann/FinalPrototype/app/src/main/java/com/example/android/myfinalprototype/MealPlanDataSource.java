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

public class MealPlanDataSource {

    OrganizerDBHelper mealPlanDBHelper;
    SQLiteDatabase mWriteableDatabase;
    Context mContext;

    /**
     * Constructor
     * Initializes the context and DatabaseHelper
     * @param context - Context passed in
     */

    public MealPlanDataSource(Context context) {
        mContext = context;
        mealPlanDBHelper = new OrganizerDBHelper(mContext);
    }

    /**
     * Opens the database
     */

    public void open(){
        mWriteableDatabase = mealPlanDBHelper.getWritableDatabase();
    }

    /**
     * Closes the database
     */

    public void close(){
        if(mWriteableDatabase != null && mWriteableDatabase.isOpen() ){
            mealPlanDBHelper.close();
        }
    }

    /**
     * This method inserts a new item into the table
     * @param planEntry - A MealPlanEntry object
     */
    public void insertMealPlan(MealPlanEntry planEntry){

        ContentValues values = new ContentValues();
        values.put(MealPlanContract.PlanEntry.MONDAY_MEALS, planEntry.getMondayMeals());
        values.put(MealPlanContract.PlanEntry.TUESDAY_MEALS, planEntry.getTuesdayMeals());
        values.put(MealPlanContract.PlanEntry.WEDNESDAY_MEALS, planEntry.getWednesdayMeals());
        values.put(MealPlanContract.PlanEntry.THURSDAY_MEALS, planEntry.getThursdayMeals());
        values.put(MealPlanContract.PlanEntry.FRIDAY_MEALS, planEntry.getFridayMeals());
        values.put(MealPlanContract.PlanEntry.SATURDAY_MEALS, planEntry.getSaturdayMeals());
        values.put(MealPlanContract.PlanEntry.SUNDAY_MEALS, planEntry.getSundayMeals());

        long insertId = mWriteableDatabase.insert(MealPlanContract.PlanEntry.MEAL_TABLE,
                null, values);
        if(insertId != -1){
            planEntry.setId(insertId);
        }
    }

    /**
     * This method returns a List with the current week's meal plan.
     * @return - the task list
     */
    public List<String> getPlan(){

        List<String> planList = new ArrayList<>();
        SQLiteDatabase mReadableDatabase = mealPlanDBHelper.getReadableDatabase();

        Cursor cursor = mReadableDatabase.rawQuery("SELECT * FROM "
                + MealPlanContract.PlanEntry.MEAL_TABLE, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.MONDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.TUESDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.WEDNESDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.THURSDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.FRIDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.SATURDAY_MEALS)));
            planList.add(cursor.getString(cursor.getColumnIndex(MealPlanContract.PlanEntry.SUNDAY_MEALS)));
            cursor.moveToNext();
        }

        return planList;

    }


    /**
     * This method deletes all the items in the table
     */
    public void deleteAll(){
        mWriteableDatabase.delete(MealPlanContract.PlanEntry.MEAL_TABLE,
                null, null);

    }
}
