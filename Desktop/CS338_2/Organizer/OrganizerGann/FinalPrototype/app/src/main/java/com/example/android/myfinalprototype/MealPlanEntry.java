package com.example.android.myfinalprototype;


/**
 * This is the base model for an entry of Meal Plan items. It has getters for each
 * value so they can later be accessed by other classes.
 * Created by Kaitlin on 2/13/2018.
 */

public class MealPlanEntry {

    private long id;
    private String mondayMeals;
    private String tuesdayMeals;
    private String wednesdayMeals;
    private String thursdayMeals;
    private String fridayMeals;
    private String saturdayMeals;
    private String sundayMeals;

    /**
     * Constructor initializes values above to the input values.
     * @param mondayMeals- The entered text for this day's meals
     * @param tuesdayMeals- The entered text for this day's meals
     * @param wednesdayMeals- The entered text for this day's meals
     * @param thursdayMeals- The entered text for this day's meals
     * @param fridayMeals- The entered text for this day's meals
     * @param saturdayMeals- The entered text for this day's meals
     * @param sundayMeals- The entered text for this day's meals
     */

    public MealPlanEntry(String mondayMeals, String tuesdayMeals,
                         String wednesdayMeals, String thursdayMeals,
                         String fridayMeals, String saturdayMeals, String sundayMeals) {
        this.mondayMeals = mondayMeals;
        this.tuesdayMeals = tuesdayMeals;
        this.wednesdayMeals = wednesdayMeals;
        this.thursdayMeals = thursdayMeals;
        this.fridayMeals = fridayMeals;
        this.saturdayMeals = saturdayMeals;
        this.sundayMeals = sundayMeals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMondayMeals() {
        return mondayMeals;
    }

    public String getTuesdayMeals() {
        return tuesdayMeals;
    }


    public String getWednesdayMeals() {
        return wednesdayMeals;
    }


    public String getThursdayMeals() {
        return thursdayMeals;
    }


    public String getFridayMeals() {
        return fridayMeals;
    }


    public String getSaturdayMeals() {
        return saturdayMeals;
    }


    public String getSundayMeals() {
        return sundayMeals;
    }

}
