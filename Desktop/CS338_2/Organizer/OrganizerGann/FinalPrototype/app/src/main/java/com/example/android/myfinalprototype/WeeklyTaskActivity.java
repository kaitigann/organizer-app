package com.example.android.myfinalprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/* This class is a Weekly Task Activity. The user can enter their weekly tasks and hit a save button
 * to save the entries, which will then be displayed on another layout.
 */

public class WeeklyTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    WeeklyTaskDataSource taskDataSource;
    List<String> taskList;
    ArrayList<SpinnerItem> list;

    /**
     *
     * OnCreate initializes the navigation Spinner for the editable screen and the data source. It
     * also calls loadSavedScreen if things have been entered in the task list, so the user can
     * go and come to their saved task list as they please if they have a saved task list.
     *
     * @param savedInstanceState - The saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_tasks);

        taskDataSource = new WeeklyTaskDataSource(this);

        Spinner mySpinner = findViewById(R.id.my_spinner);

        list = new ArrayList<>();

        list.add(new SpinnerItem("Weekly Tasks", R.drawable.ic_tasks_spinner));
        list.add(new SpinnerItem("Monthly Budget", R.drawable.ic_budget_spinner));
        list.add(new SpinnerItem("Meal Plan", R.drawable.ic_meal_plan_spinner));
        list.add(new SpinnerItem("Home", R.drawable.ic_home_spinner));
        list.add(new SpinnerItem("Shopping List", R.drawable.ic_shopping_cart_spinner));

        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        taskDataSource.open();
        if(taskDataSource.getTaskList().size() > 0){
            loadSavedTaskScreen();
        }
        taskDataSource.close();
    }

    /*
     * This method dictates the action that occurs when an item from the spinner is selected.
     */

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 1){
            startActivity(new Intent(this, MonthlyBudgetActivity.class));
        }
        if(i == 2){
            startActivity(new Intent(this, MealPlanActivity.class));
        }
        if(i == 3){
            startActivity(new Intent(this, MainActivity.class));
        }
        if(i == 4){
            startActivity(new Intent(this, ShoppingListActivity.class));
        }
    }

    /* This method is intentionally left blank because when nothing is selected, nothing should
     * happen.
     */

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * This method saves the entered data by grabbing the text from EditText values and creating
     * a new row of data and inserting the data into the database. It then calls loadSavedScreen
     * to display the saved values in the new layout.
     *
     * @param view - The view being passed in
     */

    public void saveTaskEntries(View view){


        String mondayTasks = ((EditText) findViewById(R.id.mondayTasks)).getText().toString();
        String tuesdayTasks = ((EditText)findViewById(R.id.tuesdayTasks)).getText().toString();
        String wednesdayTasks = ((EditText)findViewById(R.id.wednesdayTasks)).getText().toString();
        String thursdayTasks = ((EditText)findViewById(R.id.thursdayTasks)).getText().toString();
        String fridayTasks = ((EditText)findViewById(R.id.fridayTasks)).getText().toString();
        String saturdayTasks = ((EditText)findViewById(R.id.saturdayTasks)).getText().toString();
        String sundayTasks= ((EditText)findViewById(R.id.sundayTasks)).getText().toString();

        WeeklyTasksEntry tasksEntry = new WeeklyTasksEntry(mondayTasks, tuesdayTasks, wednesdayTasks,
                thursdayTasks, fridayTasks, saturdayTasks, sundayTasks);

        taskDataSource.open();
        taskDataSource.insertTasks(tasksEntry);
        taskDataSource.close();
        loadSavedTaskScreen();

    }

    /**
     *  This method loads the new layout with the saved data. This allows the user to navigate to
     *  and from their saved task list.
     */
    public void loadSavedTaskScreen(){
        taskDataSource.open();
        taskList = taskDataSource.getTaskList();
        taskDataSource.close();
        setContentView(R.layout.saved_weekly_tasks);
        if(!taskList.isEmpty())
        {
            TextView savedMondayTasks = findViewById(R.id.savedMondayTasks);
            savedMondayTasks.setText(taskList.get(0));
            TextView savedTuesdayTasks = findViewById(R.id.savedTuesdayTasks);
            savedTuesdayTasks.setText(taskList.get(1));
            TextView savedWednesdayTasks = findViewById(R.id.savedWednesdayTasks);
            savedWednesdayTasks.setText(taskList.get(2));
            TextView savedThursdayTasks = findViewById(R.id.savedThursdayTasks);
            savedThursdayTasks.setText(taskList.get(3));
            TextView savedFridayTasks = findViewById(R.id.savedFridayTasks);
            savedFridayTasks.setText(taskList.get(4));
            TextView savedSaturdayTasks = findViewById(R.id.savedSaturdayTasks);
            savedSaturdayTasks.setText(taskList.get(5));
            TextView savedSundayTasks = findViewById(R.id.savedSundayTasks);
            savedSundayTasks.setText(taskList.get(6));
        }

        // Because we are in a new layout, the spinner from the editable screen is lost. Therefore,
        // a new spinner is added for continuity.
        Spinner mySpinner = findViewById(R.id.saved_spinner);
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    /**
     * This method removes the data and refreshes the activity so the user can enter new tasks.
     * @param view - The view being passed in
     */
    public void newTaskEntries(View view){

        taskDataSource.open();
        taskDataSource.deleteAll();
        taskDataSource.close();
        Intent intent = new Intent(this, WeeklyTaskActivity.class);
        startActivity(intent);
    }

}
