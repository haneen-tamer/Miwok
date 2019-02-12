package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nour on 3/6/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //Resource id for background color
    private int mBckgdColorId;


    /**
     * serves as an ArrayAdapter wor the Word ArrayList
     * @param context context of the activity
     * @param list  arrayList to be displayed in list item
     */
    public WordAdapter(Activity context, ArrayList<Word> list, int bckgdColor) {
        super(context, 0, list);
        mBckgdColorId=bckgdColor;
    }



    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWordItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_word
        TextView miwokTextView =  listItemView.findViewById(R.id.miwok_word);
        // Get the miwok word from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWordItem.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID def_translation_word
        TextView defaultTranslationTextView = listItemView.findViewById(R.id.def_translation_word);
        // Get the default translation from the current Word object and
        // set this text on the default translation TextView
        defaultTranslationTextView.setText(currentWordItem.getDefaultWord());

        //Find the ImageView in the list_item.xml layout with the ID ic_img
        ImageView imgImageView = listItemView.findViewById(R.id.ic_img);


        if(currentWordItem.hasImage()){
            //Get the img resource id from current word object and
            //set this resource id on the img ImageView
            imgImageView.setImageResource(currentWordItem.getImgId());

            //Make imageView Visible
            imgImageView.setVisibility(View.VISIBLE);
        } else{
            //hide imageView
            imgImageView.setVisibility(View.GONE);
        }

        //Find ViewGroup textContainer in the List_item.xml layout
        ViewGroup textContainer = listItemView.findViewById(R.id.text_container);
        //Get the color resource ID
        int color = ContextCompat.getColor(getContext(),mBckgdColorId);
        // and set it as background color
        textContainer.setBackgroundColor(color);


        return listItemView;
    }


}
