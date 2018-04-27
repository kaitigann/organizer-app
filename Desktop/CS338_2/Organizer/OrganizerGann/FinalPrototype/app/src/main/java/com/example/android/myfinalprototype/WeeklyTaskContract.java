package com.example.android.myfinalprototype;

import android.provider.BaseColumns;

/**
 * These classes serve as a contract for the WeeklyTaskActivity and the Database.
 * Created by Kaitlin on 2/20/2018.
 */

public class WeeklyTaskContract {

    public static abstract class TaskEntry implements BaseColumns {

        public static final String TASK_TABLE = "task_list";
        public static final String ID_FIELD  = "_id";
        public static final String COLUMN_MONDAY = "mondayTasks";
        public static final String COLUMN_TUESDAY = "tuesdayTasks";
        public static final String COLUMN_WEDNESDAY = "wednesdayTasks";
        public static final String COLUMN_THURSDAY = "thursdayTasks";
        public static final String COLUMN_FRIDAY = "fridayTasks";
        public static final String COLUMN_SATURDAY = "saturdayTasks";
        public static final String COLUMN_SUNDAY = "sundayTasks";

    }
}
