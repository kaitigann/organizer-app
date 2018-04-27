package com.example.android.myfinalprototype;

/**
 * This is the base model for an entry of Weekly Task items. It has getters for each
 * value so they can later be accessed by other classes.
 * Created by Kaitlin on 2/13/2018.
 */

public class WeeklyTasksEntry {

    private long id;
    private String mondayTasks;
    private String tuesdayTasks;
    private String wednesdayTasks;
    private String thursdayTasks;
    private String fridayTasks;
    private String saturdayTasks;
    private String sundayTasks;


    /**
     * Constructor initializes values above to the input values.
     * @param mondayTasks - The entered text for this day's tasks
     * @param tuesdayTasks - The entered text for this day's tasks
     * @param wednesdayTasks - The entered text for this day's tasks
     * @param thursdayTasks - The entered text for this day's tasks
     * @param fridayTasks - The entered text for this day's tasks
     * @param saturdayTasks - The entered text for this day's tasks
     * @param sundayTasks - The entered text for this day's tasks
     */
    public WeeklyTasksEntry(String mondayTasks, String tuesdayTasks,
                            String wednesdayTasks, String thursdayTasks, String fridayTasks,
                            String saturdayTasks, String sundayTasks) {
        this.mondayTasks = mondayTasks;
        this.tuesdayTasks = tuesdayTasks;
        this.wednesdayTasks = wednesdayTasks;
        this.thursdayTasks = thursdayTasks;
        this.fridayTasks = fridayTasks;
        this.saturdayTasks = saturdayTasks;
        this.sundayTasks = sundayTasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMondayTasks() {
        return mondayTasks;
    }

    public String getTuesdayTasks() {
        return tuesdayTasks;
    }

    public String getWednesdayTasks() {
        return wednesdayTasks;
    }

    public String getThursdayTasks() {
        return thursdayTasks;
    }

    public String getFridayTasks() {
        return fridayTasks;
    }

    public String getSaturdayTasks() {
        return saturdayTasks;
    }

    public String getSundayTasks() {
        return sundayTasks;
    }

}
