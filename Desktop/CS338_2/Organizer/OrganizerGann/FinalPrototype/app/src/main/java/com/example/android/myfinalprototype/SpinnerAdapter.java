package com.example.android.myfinalprototype;

/**
 * This custom spinner adapter was necessary so I could add icons to my spinner.
 * Created by Kaitlin on 3/3/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    int groupid;
    ArrayList<SpinnerItem> list;
    LayoutInflater inflater;

    /**
     * Constructor
     * This constructor initializes the items declared above
     * @param context - The context for the activity
     * @param groupid - The group id for the Adapter
     * @param id - The id
     * @param list - The list of SpinnerItems
     */
    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<SpinnerItem>
            list){
        super(context,id,list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    /**
     * This method sets a spinner row and returns the view.
     *
     * @param position - The position in the list
     * @param convertView - The converted view
     * @param parent - The parent viewGroup
     * @return The item view
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent ){

        View itemView = inflater.inflate(groupid,parent,false);
        ImageView imageView= itemView.findViewById(R.id.spinnerIcon);
        imageView.setImageResource(list.get(position).getImageId());
        TextView textView= itemView.findViewById(R.id.spinnerText);
        textView.setText(list.get(position).getText());
        return itemView;
    }

    /**
     * This method returns the dropDownView
     * @param position - The position in the list
     * @param convertView - The convertedView
     * @param parent - The parent viewGroup
     * @return - The view
     */
    public View getDropDownView(int position, View convertView, ViewGroup
            parent){
        return getView(position,convertView,parent);

    }
}
