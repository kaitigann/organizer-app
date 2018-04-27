package com.example.android.myfinalprototype;

/**
 * This is the base model for a single spinner row with an icon and text.
 * Created by Kaitlin on 3/3/2018.
 */

public class SpinnerItem {
    String text;
    Integer imageId;
    public SpinnerItem(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}
