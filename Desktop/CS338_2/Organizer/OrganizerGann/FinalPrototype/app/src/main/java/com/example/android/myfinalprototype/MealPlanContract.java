package com.example.android.myfinalprototype;

import android.provider.BaseColumns;

/**
 * These classes serve as a contract for the MealPlan and Database.
 * Created by Kaitlin on 2/20/2018.
 */

public class MealPlanContract {

    public static abstract class PlanEntry implements BaseColumns {

        public static final String MEAL_TABLE = "meal_plan";
        public static final String ID_FIELD  = "_id";
        public static final String MONDAY_MEALS = "mondayMeals";
        public static final String TUESDAY_MEALS = "tuesdayMeals";
        public static final String WEDNESDAY_MEALS = "wednesdayMeals";
        public static final String THURSDAY_MEALS = "thursdayMeals";
        public static final String FRIDAY_MEALS = "fridayMeals";
        public static final String SATURDAY_MEALS = "saturdayMeals";
        public static final String SUNDAY_MEALS = "sundayMeals";

    }
}
