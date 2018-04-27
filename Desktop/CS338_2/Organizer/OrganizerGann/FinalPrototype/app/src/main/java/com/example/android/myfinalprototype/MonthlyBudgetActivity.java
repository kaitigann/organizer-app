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


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* This class is a Monthly Budget Activity. The user can enter the name of their income, fixed
 * expenses, variable expenses, and enter amounts for all of the above which will be used to
 * calculate the total income, expenses, and savings for the month.
 *
 */

public class MonthlyBudgetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    MonthlyBudgetDataSource mBudgetDataSource;
    List<String> budgetList;
    ArrayList<SpinnerItem> list;
    /*
     * OnCreate initializes the navigation Spinner and the datasource
     *
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_budget);

        mBudgetDataSource = new MonthlyBudgetDataSource(this);

        Spinner mySpinner = findViewById(R.id.my_spinner);

        list = new ArrayList<>();
        list.add(new SpinnerItem("Monthly Budget", R.drawable.ic_budget_spinner));
        list.add(new SpinnerItem("Home", R.drawable.ic_home_spinner));
        list.add(new SpinnerItem("Meal Plan", R.drawable.ic_meal_plan_spinner));
        list.add(new SpinnerItem("Weekly Tasks", R.drawable.ic_tasks_spinner));
        list.add(new SpinnerItem("Shopping List", R.drawable.ic_shopping_cart_spinner));
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        mBudgetDataSource.open();

        if(mBudgetDataSource.getBudgetList().size() > 0){
          loadSavedBudgetScreen();
        }
        mBudgetDataSource.close();

    }

    /*
     * This method dictates the action that occurs when an item from the spinner is selected.
     */

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 1){
            startActivity(new Intent(this, MainActivity.class));
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

    /* This method is intentionally left blank because when nothing is selected, nothing should
     * happen.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    /**
     * This method saves the entered data by grabbing the text from EditText values and creating
     * a new row of data and inserting the data into the database. If any of the data is
     * empty in some way, 0.00 is entered for the value. This is so that I don't get errors later
     * when adding and dividing with these amounts. Then, loadSavedScreen is called to load the
     * layout with the saved entries.
     *
     * @param view - The view being passed in
     */

    public void saveBudgetEntries(View view){

        String incomeAmt1 = ((EditText)findViewById(R.id.incomeAmt1)).getText().toString();
        if(incomeAmt1.equals("") || incomeAmt1.equals(" "))
            incomeAmt1 = "0.00";
        String incomeAmt2 = ((EditText)findViewById(R.id.incomeAmt2)).getText().toString();
        if(incomeAmt2.equals("") || incomeAmt2.equals(" "))
            incomeAmt2 = "0.00";
        String incomeName1 = ((EditText)findViewById(R.id.nameOfIncome1)).getText().toString();
        String incomeName2 = ((EditText)findViewById(R.id.nameOfIncome2)).getText().toString();
        String fixedAmt1 = ((EditText)findViewById(R.id.fixedAmt1)).getText().toString();
        if(fixedAmt1.equals("") || fixedAmt1.equals(" "))
            fixedAmt1 = "0.00";
        String fixedAmt2 = ((EditText)findViewById(R.id.fixedAmt2)).getText().toString();
        if(fixedAmt2.equals("") || fixedAmt2.equals(" "))
            fixedAmt2 = "0.00";
        String fixedAmt3 = ((EditText)findViewById(R.id.fixedAmt3)).getText().toString();
        if(fixedAmt3.equals("") || fixedAmt3.equals(" "))
            fixedAmt3 = "0.00";
        String fixedAmt4 = ((EditText)findViewById(R.id.fixedAmt4)).getText().toString();
        if(fixedAmt4.equals("") || fixedAmt4.equals(" "))
            fixedAmt4 = "0.00";
        String fixedAmt5 = ((EditText)findViewById(R.id.fixedAmt5)).getText().toString();
        if(fixedAmt5.equals("") || fixedAmt5.equals(" "))
            fixedAmt5 = "0.00";
        String fixedAmt6 = ((EditText)findViewById(R.id.fixedAmt6)).getText().toString();
        if(fixedAmt6.equals("") || fixedAmt6.equals(" "))
            fixedAmt6 = "0.00";
        String fixedAmt7 = ((EditText)findViewById(R.id.fixedAmt7)).getText().toString();
        if(fixedAmt7.equals("") || fixedAmt7.equals(" "))
            fixedAmt7 = "0.00";
        String fixedName1 = ((EditText)findViewById(R.id.fixedExpenseName1)).getText().toString();
        String fixedName2 = ((EditText)findViewById(R.id.fixedExpenseName2)).getText().toString();
        String fixedName3 = ((EditText)findViewById(R.id.fixedExpenseName3)).getText().toString();
        String fixedName4 = ((EditText)findViewById(R.id.fixedExpenseName4)).getText().toString();
        String fixedName5 = ((EditText)findViewById(R.id.fixedExpenseName5)).getText().toString();
        String fixedName6 = ((EditText)findViewById(R.id.fixedExpenseName6)).getText().toString();
        String fixedName7 = ((EditText)findViewById(R.id.fixedExpenseName7)).getText().toString();
        String variableAmt1 = ((EditText)findViewById(R.id.variableAmt1)).getText().toString();
        if(variableAmt1.equals("") || variableAmt1.equals(" "))
            variableAmt1 = "0.00";
        String variableAmt2 = ((EditText)findViewById(R.id.variableAmt2)).getText().toString();
        if(variableAmt2.equals("") || variableAmt2.equals(" "))
            variableAmt2 = "0.00";
        String variableAmt3 = ((EditText)findViewById(R.id.variableAmt3)).getText().toString();
        if(variableAmt3.equals("") || variableAmt3.equals(" "))
            variableAmt3 = "0.00";
        String variableAmt4 = ((EditText)findViewById(R.id.variableAmt4)).getText().toString();
        if(variableAmt4.equals("") || variableAmt4.equals(" "))
            variableAmt4 = "0.00";
        String variableAmt5 = ((EditText)findViewById(R.id.variableAmt5)).getText().toString();
        if(variableAmt5.equals("") || variableAmt5.equals(" "))
            variableAmt5 = "0.00";
        String variableAmt6 = ((EditText)findViewById(R.id.variableAmt6)).getText().toString();
        if(variableAmt6.equals("") || variableAmt6.equals(" "))
            variableAmt6 = "0.00";
        String variableAmt7 = ((EditText)findViewById(R.id.variableAmt7)).getText().toString();
        if(variableAmt7.equals("") || variableAmt7.equals(" "))
            variableAmt7 = "0.00";
        String variableName1 = ((EditText)findViewById(R.id.variableExpenseName1)).getText().toString();
        String variableName2 = ((EditText)findViewById(R.id.variableExpenseName2)).getText().toString();
        String variableName3 = ((EditText)findViewById(R.id.variableExpenseName3)).getText().toString();
        String variableName4 = ((EditText)findViewById(R.id.variableExpenseName4)).getText().toString();
        String variableName5 = ((EditText)findViewById(R.id.variableExpenseName5)).getText().toString();
        String variableName6 = ((EditText)findViewById(R.id.variableExpenseName6)).getText().toString();
        String variableName7 = ((EditText)findViewById(R.id.variableExpenseName7)).getText().toString();

        MonthlyBudgetEntry newBudget = new MonthlyBudgetEntry(incomeAmt1, incomeAmt2, incomeName1,
                incomeName2, fixedAmt1, fixedAmt2, fixedAmt3, fixedAmt4, fixedAmt5, fixedAmt6,
                fixedAmt7, fixedName1, fixedName2, fixedName3, fixedName4, fixedName5, fixedName6,
                fixedName7, variableAmt1, variableAmt2, variableAmt3, variableAmt4, variableAmt5,
                variableAmt6, variableAmt7, variableName1, variableName2, variableName3, variableName4,
                variableName5, variableName6, variableName7);

        mBudgetDataSource.open();
        mBudgetDataSource.insertBudget(newBudget);
        mBudgetDataSource.close();
        loadSavedBudgetScreen();

    }

    /**
     * This method removes the data and refreshes the activity so the user can enter a new budget.
     * @param view - The view being passed in
     */

    public void newBudgetEntries(View view){
        mBudgetDataSource.open();
        mBudgetDataSource.deleteAll();
        mBudgetDataSource.close();
        Intent intent = new Intent(this,MonthlyBudgetActivity.class);
        startActivity(intent);
    }

    /**
     * This method loads the saved layout and inserts the saved data into the saved layout's
     * textViews.
     */
    public void loadSavedBudgetScreen(){

        // This helps to format the data
        DecimalFormat df = new DecimalFormat("#####0.00");
        double totalIncome;
        double totalSavings;
        double totalExpenses;
        double totalVariable;
        double totalFixed;

        mBudgetDataSource.open();
        budgetList = mBudgetDataSource.getBudgetList();
        mBudgetDataSource.close();

        setContentView(R.layout.saved_monthly_budget);

        if(!budgetList.isEmpty()){

            TextView savedIncomeAmt1 = findViewById(R.id.savedIncomeAmt1);
            savedIncomeAmt1.setText(budgetList.get(0));
            TextView savedIncomeAmt2 = findViewById(R.id.savedIncomeAmt2);
            savedIncomeAmt2.setText(budgetList.get(1));
            TextView savedIncomeName1 = findViewById(R.id.savedNameOfIncome1);
            savedIncomeName1.setText(budgetList.get(2));
            TextView savedIncomeName2 = findViewById(R.id.savedNameOfIncome2);
            savedIncomeName2.setText(budgetList.get(3));
            TextView savedFixedAmt1 = findViewById(R.id.savedFixedAmt1);
            savedFixedAmt1.setText(budgetList.get(4));
            TextView savedFixedAmt2 = findViewById(R.id.savedFixedAmt2);
            savedFixedAmt2.setText(budgetList.get(5));
            TextView savedFixedAmt3 = findViewById(R.id.savedFixedAmt3);
            savedFixedAmt3.setText(budgetList.get(6));
            TextView savedFixedAmt4 = findViewById(R.id.savedFixedAmt4);
            savedFixedAmt4.setText(budgetList.get(7));
            TextView savedFixedAmt5 = findViewById(R.id.savedFixedAmt5);
            savedFixedAmt5.setText(budgetList.get(8));
            TextView savedFixedAmt6 = findViewById(R.id.savedFixedAmt6);
            savedFixedAmt6.setText(budgetList.get(9));
            TextView savedFixedAmt7 = findViewById(R.id.savedFixedAmt7);
            savedFixedAmt7.setText(budgetList.get(10));
            TextView savedFixedName1 = findViewById(R.id.savedFixedExpenseName1);
            savedFixedName1.setText(budgetList.get(11));
            TextView savedFixedName2 = findViewById(R.id.savedFixedExpenseName2);
            savedFixedName2.setText(budgetList.get(12));
            TextView savedFixedName3 = findViewById(R.id.savedFixedExpenseName3);
            savedFixedName3.setText(budgetList.get(13));
            TextView savedFixedName4 = findViewById(R.id.savedFixedExpenseName4);
            savedFixedName4.setText(budgetList.get(14));
            TextView savedFixedName5 = findViewById(R.id.savedFixedExpenseName5);
            savedFixedName5.setText(budgetList.get(15));
            TextView savedFixedName6 = findViewById(R.id.savedFixedExpenseName6);
            savedFixedName6.setText(budgetList.get(16));
            TextView savedFixedName7 = findViewById(R.id.savedFixedExpenseName7);
            savedFixedName7.setText(budgetList.get(17));
            TextView savedVariableAmt1 = findViewById(R.id.savedVariableAmt1);
            savedVariableAmt1.setText(budgetList.get(18));
            TextView savedVariableAmt2 = findViewById(R.id.savedVariableAmt2);
            savedVariableAmt2.setText(budgetList.get(19));
            TextView savedVariableAmt3 = findViewById(R.id.savedVariableAmt3);
            savedVariableAmt3.setText(budgetList.get(20));
            TextView savedVariableAmt4 = findViewById(R.id.savedVariableAmt4);
            savedVariableAmt4.setText(budgetList.get(21));
            TextView savedVariableAmt5 = findViewById(R.id.savedVariableAmt5);
            savedVariableAmt5.setText(budgetList.get(22));
            TextView savedVariableAmt6 = findViewById(R.id.savedVariableAmt6);
            savedVariableAmt6.setText(budgetList.get(23));
            TextView savedVariableAmt7 = findViewById(R.id.savedVariableAmt7);
            savedVariableAmt7.setText(budgetList.get(24));
            TextView savedVariableName1 = findViewById(R.id.savedVariableExpenseName1);
            savedVariableName1.setText(budgetList.get(25));
            TextView savedVariableName2 = findViewById(R.id.savedVariableExpenseName2);
            savedVariableName2.setText(budgetList.get(26));
            TextView savedVariableName3 = findViewById(R.id.savedVariableExpenseName3);
            savedVariableName3.setText(budgetList.get(27));
            TextView savedVariableName4 = findViewById(R.id.savedVariableExpenseName4);
            savedVariableName4.setText(budgetList.get(28));
            TextView savedVariableName5 = findViewById(R.id.savedVariableExpenseName5);
            savedVariableName5.setText(budgetList.get(29));
            TextView savedVariableName6 = findViewById(R.id.savedVariableExpenseName6);
            savedVariableName6.setText(budgetList.get(30));
            TextView savedVariableName7 = findViewById(R.id.savedVariableExpenseName7);
            savedVariableName7.setText(budgetList.get(31));

            // Adding the Double values of the income strings to get the total income
            totalIncome = Double.parseDouble(savedIncomeAmt1.getText().toString())
                    + Double.parseDouble(savedIncomeAmt2.getText().toString());

            //Adding the Double values of the fixed expenses to get the total fixed expenses
            totalFixed = Double.parseDouble(savedFixedAmt1.getText().toString())
                    + Double.parseDouble(savedFixedAmt2.getText().toString())
                    + Double.parseDouble(savedFixedAmt3.getText().toString())
                    + Double.parseDouble(savedFixedAmt4.getText().toString())
                    + Double.parseDouble(savedFixedAmt5.getText().toString())
                    + Double.parseDouble(savedFixedAmt6.getText().toString())
                    + Double.parseDouble(savedFixedAmt7.getText().toString());

            //Adding the Double values of the variable expenses to get the total variable expenses
            totalVariable = Double.parseDouble(savedVariableAmt1.getText().toString())
                    + Double.parseDouble(savedVariableAmt2.getText().toString())
                    + Double.parseDouble(savedVariableAmt3.getText().toString())
                    + Double.parseDouble(savedVariableAmt4.getText().toString())
                    + Double.parseDouble(savedVariableAmt5.getText().toString())
                    + Double.parseDouble(savedVariableAmt6.getText().toString())
                    + Double.parseDouble(savedVariableAmt7.getText().toString());


            totalExpenses = totalFixed + totalVariable;
            totalSavings = totalIncome - totalExpenses;

            //The following code sets the text of the total amounts to the correct values
            TextView savedTotalIncomeAmt = findViewById(R.id.savedTotalIncomeAmt);
            totalIncome = Double.valueOf(df.format(totalIncome));
            savedTotalIncomeAmt.setText("AMOUNT=   " + String.valueOf(totalIncome));

            TextView savedTotalFixedAmt = findViewById(R.id.savedTotalFixedAmt);
            totalFixed = Double.valueOf(df.format(totalFixed));
            savedTotalFixedAmt.setText("AMOUNT=   " +String.valueOf(totalFixed));

            TextView savedTotalVariableAmt = findViewById(R.id.savedTotalVariableAmt);
            totalVariable = Double.valueOf(df.format(totalVariable));
            savedTotalVariableAmt.setText("AMOUNT=   " +String.valueOf(totalVariable));

            TextView savedTotalExpensesAmt = findViewById(R.id.savedTotalExpensesAmt);
            totalExpenses = Double.valueOf(df.format(totalExpenses));
            savedTotalExpensesAmt.setText("AMOUNT=   " +String.valueOf(totalExpenses));

            TextView savedTotalSavingsAmt = findViewById(R.id.savedTotalSavingsAmt);
            totalSavings = Double.valueOf(df.format(totalSavings));
            savedTotalSavingsAmt.setText("AMOUNT=   " +String.valueOf(totalSavings));
        }

        // This new spinner added to the saved layout allows the user to navigate to and from
        // the saved screen to view their saved budget.

        Spinner savedSpinner = findViewById(R.id.saved_spinner);
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        savedSpinner.setAdapter(myAdapter);
        savedSpinner.setOnItemSelectedListener(this);
    }

}