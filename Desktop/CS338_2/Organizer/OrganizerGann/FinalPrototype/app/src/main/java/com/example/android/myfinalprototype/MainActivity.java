/*
 * This Main Activity will eventually use Fragments (once we learn about them) to display each
 *  day's tasks and meal plan on the home screen.
 *
 */
package com.example.android.myfinalprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MealPlanDataSource mealPlanDataSource;
    WeeklyTaskDataSource taskDataSource;
    List<String> mealList;
    List<String> taskList;
    Calendar rightNow;


    /**
     * Initializes Spinner for navigation, gets today's date and calls setTodaysMeals/setTodaysTasks
     * to set the two textViews on the main screen.
     * @param savedInstanceState - The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealPlanDataSource = new MealPlanDataSource(this);
        taskDataSource = new WeeklyTaskDataSource(this);

        Spinner mySpinner = findViewById(R.id.my_spinner);

        ArrayList<SpinnerItem> list = new ArrayList<>();
        list.add(new SpinnerItem("Home", R.drawable.ic_home_spinner));
        list.add(new SpinnerItem("Monthly Budget", R.drawable.ic_budget_spinner));
        list.add(new SpinnerItem("Meal Plan", R.drawable.ic_meal_plan_spinner));
        list.add(new SpinnerItem("Weekly Tasks", R.drawable.ic_tasks_spinner));
        list.add(new SpinnerItem("Shopping List", R.drawable.ic_shopping_cart_spinner));
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        //The following code gets an instance of Calendar, uses it to find the day of the week, and
        // set the textview on the main screen to today's weekday.

        rightNow = Calendar.getInstance();
        TextView todayDate = findViewById(R.id.todayDate);
        int dayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK);
        String weekDay = new DateFormatSymbols().getWeekdays()[dayOfWeek];
        todayDate.setText("Today is: " + weekDay);

        //Because I set my weeks to start on Monday in my activities (0 == Monday), some adjustments
        //have to be made to the day of the week integer which sets Sundays == 1.

        int mIntDay = dayOfWeek - 2;

        if(mIntDay == -1){
            mIntDay = 6;
        }

        setTodaysMeals(mIntDay);
        setTodaysTasks(mIntDay);
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
            startActivity(new Intent(this, WeeklyTaskActivity.class));
        }
        if(i == 4){
            startActivity(new Intent(this, ShoppingListActivity.class));
        }
    }

    /*
     *  This method is intentionally left blank, because nothing should happen when nothing is
     *  selected.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     *  This method sets the textView mealsToday to the meal plan item that is scheduled for the
     *  weekday, or to "None entered" if nothing has been entered.
     * @param mIntDay - The day of the week as an integer.
     */
    public void setTodaysMeals(int mIntDay){


        mealPlanDataSource.open();
        mealList = mealPlanDataSource.getPlan();
        TextView mealsToday = findViewById(R.id.mealsToday);

        if(!mealList.isEmpty() && !mealList.get(mIntDay).equals("")){
            mealsToday.setText(mealList.get(mIntDay));
        }
        else if(!mealList.isEmpty() && mealList.get(mIntDay).equals(""))
            mealsToday.setText("None entered");
        else
            mealsToday.setText("None entered");


        mealPlanDataSource.close();

    }

    /**
     *  This method sets the textView tasksToday to the taks that is scheduled for the
     *  weekday, or to "None entered" if nothing has been entered.
     * @param mIntDay - The day of the week as an integer.
     */
    public void setTodaysTasks(int mIntDay){

        taskDataSource.open();
        taskList = taskDataSource.getTaskList();
        TextView tasksToday = findViewById(R.id.tasksToday);

        if(!taskList.isEmpty() && !taskList.get(mIntDay).equals("")){
            tasksToday.setText(taskList.get(mIntDay));
        }
        else if(!taskList.isEmpty() && taskList.get(mIntDay).equals(""))
            tasksToday.setText("None entered");
        else
            tasksToday.setText("None entered");

        taskDataSource.close();
    }

}
