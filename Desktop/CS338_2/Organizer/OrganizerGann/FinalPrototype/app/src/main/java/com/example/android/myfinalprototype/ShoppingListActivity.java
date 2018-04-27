package com.example.android.myfinalprototype;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/* This class is a Shopping List Activity. It allows the user to add and delete items to and from
 * a shopping list. The user can select an item in the ListView and press "delete" to delete it out.
 */

public class ShoppingListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ShoppingDataSource dataSource;
    Button addButton;
    Button deleteButton;
    ListView mListView;
    ArrayAdapter<String> listAdapter;
    List<String> itemList;

    /**
     * OnCreate initializes the datasource, navigation spinner, and the listView. It also defines
     * the add and delete buttons, and their onClick listeners.
     * @param savedInstanceState - The saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        dataSource = new ShoppingDataSource(this);
        dataSource.open();

        Spinner mySpinner = findViewById(R.id.my_spinner);

        ArrayList<SpinnerItem> list = new ArrayList<>();
        list.add(new SpinnerItem("Shopping List", R.drawable.ic_shopping_cart_spinner));
        list.add(new SpinnerItem("Monthly Budget", R.drawable.ic_budget_spinner));
        list.add(new SpinnerItem("Meal Plan", R.drawable.ic_meal_plan_spinner));
        list.add(new SpinnerItem("Weekly Tasks", R.drawable.ic_tasks_spinner));
        list.add(new SpinnerItem("Home", R.drawable.ic_home_spinner));
        SpinnerAdapter myAdapter = new SpinnerAdapter(this,
                R.layout.spinner_row1,R.id.spinnerText,list);

        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);


        itemList = dataSource.retrieveAll();
        dataSource.close();

        mListView = findViewById(R.id.shoppingListView);
        listAdapter = new ArrayAdapter <> (this, android.R.layout.simple_list_item_1, itemList);

        //If the item list is not empty, setting the adapter
        if(!itemList.isEmpty()){
            mListView.setAdapter(listAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // This is a new view that focuses on a single item and contains a delete button
               setContentView(R.layout.show_shopping_item);
               final String ITEM = listAdapter.getItem(position);

               TextView showItem = findViewById(R.id.showItem);
               showItem.setText(listAdapter.getItem(position));

               deleteButton = findViewById(R.id.deleteButton);

                deleteButton.setOnClickListener(new View.OnClickListener(){
                  @Override
                  public void onClick (View v) {

                      dataSource.open();
                      dataSource.deleteItem(ITEM);
                      // itemList has changed so we are updating it
                      itemList = dataSource.retrieveAll();
                      dataSource.close();
                      listAdapter.notifyDataSetChanged();
                      // Restarting the activity to return to the previous screen with an updated
                      // item list that does not contain the deleted item
                      startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));

                  }});

           }}
       );

        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText itemEt = findViewById(R.id.shoppingList);
                String item = itemEt.getText().toString();

                ShoppingListEntry newEntry = new ShoppingListEntry(item);

                dataSource.open();
                dataSource.insertItem(newEntry);
                itemList = dataSource.retrieveAll();
                dataSource.close();

                // Putting a new adapter here, because of the if statement at line 69.
                // If the item list began empty and an item was added, it wouldn't update unless
                // a new list adapter was placed in the adding method. I tried just using
                // listAdapter.add() but that didn't work.

                listAdapter = new ArrayAdapter <> (getApplicationContext(),
                       android.R.layout.simple_list_item_1, itemList);
                mListView.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
                itemEt.setText(" ");

            }
        });
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
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    /* This method is intentionally left blank because when nothing is selected, nothing should
     * happen.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
