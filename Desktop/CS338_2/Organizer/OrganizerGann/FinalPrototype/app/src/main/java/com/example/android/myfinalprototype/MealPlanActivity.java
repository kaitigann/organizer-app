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

/* This class is a Meal Planning Activity. The user can enter their meal plans and hit a save button
 * to save the entries, which will then be displayed on another layout.
 */

public class MealPlanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MealPlanDataSource mealPlanDataSource;
    ArrayList<SpinnerItem> list;

    /**
     * OnCreate initializes the navigation Spinner for the editable screen and the data source. It
     * also calls loadSavedScreen if things have been entered in the meal plan, so the user can
     * go and come to their saved meal plan as they please if they have a saved meal plan.
     * @param savedInstanceState - The saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        mealPlanDataSource = new MealPlanDataSource(this);

        Spinner mySpinner = findViewById(R.id.my_spinner);

        list = new ArrayList<>();
        list.add(new SpinnerItem("Meal Plan", R.drawable.ic_meal_plan_spinner));
        list.add(new SpinnerItem("Monthly Budget", R.drawable.ic_budget_spinner));
        list.add(new SpinnerItem("Home", R.drawable.ic_home_spinner));
        list.add(new SpinnerItem("Weekly Tasks", R.drawable.ic_tasks_spinner));
        list.add(new SpinnerItem("Shopping List", R.drawable.ic_shopping_cart_spinner));
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        mealPlanDataSource.open();
        if(mealPlanDataSource.getPlan().size() > 0)
        {
            loadSavedScreen();
        }
        mealPlanDataSource.close();
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
            startActivity(new Intent(this, MainActivity.class));
        }
        if(i == 3){
            startActivity(new Intent(this, WeeklyTaskActivity.class));
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

    public void saveMealEntries(View view){


        String mondayMeals = ((EditText)findViewById(R.id.mondayMeals)).getText().toString();
        String tuesdayMeals = ((EditText)findViewById(R.id.tuesdayMeals)).getText().toString();
        String wednesdayMeals = ((EditText)findViewById(R.id.wednesdayMeals)).getText().toString();
        String thursdayMeals = ((EditText)findViewById(R.id.thursdayMeals)).getText().toString();
        String fridayMeals = ((EditText)findViewById(R.id.fridayMeals)).getText().toString();
        String saturdayMeals = ((EditText)findViewById(R.id.saturdayMeals)).getText().toString();
        String sundayMeals =((EditText)findViewById(R.id.sundayMeals)).getText().toString();

        MealPlanEntry mealPlanEntry = new MealPlanEntry(mondayMeals, tuesdayMeals, wednesdayMeals,
                thursdayMeals, fridayMeals, saturdayMeals, sundayMeals);

        mealPlanDataSource.open();
        mealPlanDataSource.insertMealPlan(mealPlanEntry);
        mealPlanDataSource.close();
        loadSavedScreen();

    }

    /**
     *  This method loads the new layout with the saved data. This allows the user to navigate to
     *  and from their saved meal plan.
     */

    public void loadSavedScreen()
    {
        mealPlanDataSource.open();
        List<String> planList = mealPlanDataSource.getPlan();
        mealPlanDataSource.close();

        setContentView(R.layout.saved_meal_plan);

        if(planList.isEmpty() == false)
        {
            TextView savedMondayMeals = findViewById(R.id.savedMondayMeals);
            savedMondayMeals.setText(planList.get(0));
            TextView savedTuesdayMeals = findViewById(R.id.savedTuesdayMeals);
            savedTuesdayMeals.setText(planList.get(1));
            TextView savedWednesdayMeals = findViewById(R.id.savedWednesdayMeals);
            savedWednesdayMeals.setText(planList.get(2));
            TextView savedThursdayMeals = findViewById(R.id.savedThursdayMeals);
            savedThursdayMeals.setText(planList.get(3));
            TextView savedFridayMeals = findViewById(R.id.savedFridayMeals);
            savedFridayMeals.setText(planList.get(4));
            TextView savedSaturdayMeals = findViewById(R.id.savedSaturdayMeals);
            savedSaturdayMeals.setText(planList.get(5));
            TextView savedSundayMeals = findViewById(R.id.savedSundayMeals);
            savedSundayMeals.setText(planList.get(6));
        }

        // Because we are in a new layout, the spinner from the editable screen is lost. Therefore,
        // a new spinner is added for continuity.

        Spinner savedSpinner = findViewById(R.id.saved_spinner);
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);
        savedSpinner.setAdapter(myAdapter);
        savedSpinner.setOnItemSelectedListener(this);
    }

    /**
     * This method removes the data and refreshes the activity so the user can enter new plans.
     * @param view - The view being passed in
     */
    public void clearMealEntries(View view){
        mealPlanDataSource.open();
        mealPlanDataSource.deleteAll();
        mealPlanDataSource.close();
        Intent intent = new Intent(this, MealPlanActivity.class);
        startActivity(intent);
    }

}
