package com.example.android.myfinalprototype;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This is an overall Database Helper that can be used by all of my activities' data sources.
 * Created by Kaitlin on 2/18/2018.
 */

public class OrganizerDBHelper extends SQLiteOpenHelper{

    private static final String TAG = OrganizerDBHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "organizer.db";
    private static final String SQL_TASK_TABLE = "CREATE TABLE "+  WeeklyTaskContract.TaskEntry.TASK_TABLE+
            "( "+ WeeklyTaskContract.TaskEntry.ID_FIELD+" INT AUTO_INCREMENT PRIMARY KEY"+
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_MONDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_TUESDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_WEDNESDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_THURSDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_FRIDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_SATURDAY + " TEXT " +
            ", "+ WeeklyTaskContract.TaskEntry.COLUMN_SUNDAY + " TEXT )";

    private static final String SQL_MEAL_PLAN = "CREATE TABLE "+  MealPlanContract.PlanEntry.MEAL_TABLE+
            "( "+ MealPlanContract.PlanEntry.ID_FIELD+" INT AUTO_INCREMENT PRIMARY KEY"+
            ", "+ MealPlanContract.PlanEntry.MONDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.TUESDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.WEDNESDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.THURSDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.FRIDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.SATURDAY_MEALS + " TEXT " +
            ", "+ MealPlanContract.PlanEntry.SUNDAY_MEALS + " TEXT )";

    private static final String SQL_SHOPPING_LIST = "CREATE TABLE "+  ShoppingContract.ShoppingEntry.SHOPPING_TABLE+
            "( "+ShoppingContract.ShoppingEntry.ID_FIELD+" INT AUTO_INCREMENT PRIMARY KEY"+
            ", "+ ShoppingContract.ShoppingEntry.COLUMN_ITEM+" TEXT )";

    private static final String SQL_BUDGET = "CREATE TABLE "+ MonthlyBudgetContract.BudgetEntry.BUDGET_TABLE+
            "( "+ MonthlyBudgetContract.BudgetEntry.ID_FIELD+" INT AUTO_INCREMENT PRIMARY KEY"+
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_INCOME1+" TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_INCOME2+" TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_INCOME1+" TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_INCOME2+" TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED1+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED2+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED3+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED4+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED5+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED6+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_FIXED7+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED1+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED2+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED3+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED4+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED5+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED6+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_FIXED7+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE1+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE2+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE3+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE4+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE5+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE6+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.AMT_VARIABLE7+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE1+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE2+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE3+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE4+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE5+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE6+ " TEXT " +
            ", "+ MonthlyBudgetContract.BudgetEntry.NAME_VARIABLE7+ " TEXT )";


    public OrganizerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate creates the tables
     * @param db - The database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TASK_TABLE);
        db.execSQL(SQL_MEAL_PLAN);
        db.execSQL(SQL_SHOPPING_LIST);
        db.execSQL(SQL_BUDGET);
        Log.i(TAG, "Database and tables created");
    }

    /**
     * onUpgrade drops the old tables and calls onCreate
     * @param db - The database
     * @param oldVersion - The old version
     * @param newVersion - The new version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ WeeklyTaskContract.TaskEntry.TASK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ MealPlanContract.PlanEntry.MEAL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ ShoppingContract.ShoppingEntry.SHOPPING_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ MonthlyBudgetContract.BudgetEntry.BUDGET_TABLE);
        onCreate(db);
        Log.i(TAG, "Database upgraded");
    }
}
