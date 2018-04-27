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
 *
 * Created by Kaitlin on 2/20/2018.
 */

public class WeeklyTaskDataSource {
    OrganizerDBHelper mTaskDBHelper;
    SQLiteDatabase mSQLiteDatabase;
    Context mContext;

    /**
     * Constructor
     * Initializes the context and DatabaseHelper
     * @param context - Context passed in
     */

    public WeeklyTaskDataSource(Context context) {
        mContext = context;
        mTaskDBHelper = new OrganizerDBHelper(mContext);
    }

    /**
     * Opens the database
     */

    public void open(){
        mSQLiteDatabase = mTaskDBHelper.getWritableDatabase();
    }

    /**
     * Closes the database
     */
    public void close(){
        if(mSQLiteDatabase != null && mSQLiteDatabase.isOpen() ){
            mTaskDBHelper.close();
        }
    }

    /**
     * This method inserts a new item into the table
     * @param newTaskEntry - A new entry to the table
     */

    public void insertTasks(WeeklyTasksEntry newTaskEntry){

        ContentValues values = new ContentValues();
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_MONDAY, newTaskEntry.getMondayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_TUESDAY, newTaskEntry.getTuesdayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_WEDNESDAY, newTaskEntry.getWednesdayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_THURSDAY, newTaskEntry.getThursdayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_FRIDAY, newTaskEntry.getFridayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_SATURDAY, newTaskEntry.getSaturdayTasks());
        values.put(WeeklyTaskContract.TaskEntry.COLUMN_SUNDAY, newTaskEntry.getSundayTasks());

        long insertId = mSQLiteDatabase.insert(WeeklyTaskContract.TaskEntry.TASK_TABLE,
                null, values);
        if(insertId != -1) {
            newTaskEntry.setId(insertId);
        }
    }

    /**
     * This method returns a List with the current week's tasks entered.
     * @return - the task list
     */
    public List<String> getTaskList(){

        List<String> taskList = new ArrayList<>();
        SQLiteDatabase mReadableDatabase = mTaskDBHelper.getReadableDatabase();
        Cursor cursor = mReadableDatabase.rawQuery("SELECT * FROM "
                + WeeklyTaskContract.TaskEntry.TASK_TABLE, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_MONDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_TUESDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_WEDNESDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_THURSDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_FRIDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_SATURDAY)));
            taskList.add(cursor.getString(cursor.getColumnIndex(WeeklyTaskContract.TaskEntry.COLUMN_SUNDAY)));
            cursor.moveToNext();
        }
        return taskList;
    }

    /**
     * This method deletes all the items in the table
     */

    public void deleteAll(){
         mSQLiteDatabase.delete(WeeklyTaskContract.TaskEntry.TASK_TABLE,
                null, null);
    }

}
