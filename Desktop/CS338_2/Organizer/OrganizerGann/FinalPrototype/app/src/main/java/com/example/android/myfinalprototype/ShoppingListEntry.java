package com.example.android.myfinalprototype;


/**
 * This is the base model for an entry of a Shopping list item
 * Created by Kaitlin on 2/13/2018.
 */

public class ShoppingListEntry {
    private long id;

    private String item;


    public ShoppingListEntry(String item) {

        this.item = item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getItem() {
        return item;
    }

}
