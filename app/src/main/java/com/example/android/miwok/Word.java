package com.example.android.miwok;

/**
 * Created by nour on 3/6/2018.
 */

/**
 * a Word object represents a vocab word the user wants to learn
 * It contains default translation and Miwok translation.
 */

public class Word {

    //Miwok word
    private String mMiwokWord;

    //default language word
    private String mDefault;

    //Image
    private int mImgId= NO_IMG_PROVIDED;
    //constant for hiding image
    private static final int    NO_IMG_PROVIDED=-1;

    //Miwok Pronunciation Audio File
    private int mRawResourceId;

    /**
     * Constructor for adding the text to Word obj
     * @param defaultTranslation the word in a language the user is familiar with
     * @param miwokTranslation the word in Miwok
//     * @param rawResourceId sound file resource id
     */
    public Word( String defaultTranslation, String miwokTranslation,int rawResourceId ){
        mMiwokWord= miwokTranslation;
        mDefault= defaultTranslation;
        mRawResourceId=rawResourceId;
    }

    /**
     * Constructor adding an img resoure id & text to Word obj
     * @param defaultTranslation the word in a language the user is familiar with
     * @param miwokTranslation the word in Miwok
     * @param imgId img resoure id
//     * @param rawResourceId sound file resource id
     */
    public Word(String defaultTranslation, String miwokTranslation, int imgId, int rawResourceId){
        mMiwokWord= miwokTranslation;
        mDefault= defaultTranslation;
        mImgId= imgId;
        mRawResourceId=rawResourceId;
    }

    /**
     * Gets the miwok translation
     * @return current miwok word in object
     */
    public String getMiwokWord(){
        return mMiwokWord;
    }

    /**
     * Gets default translation
     * @return current english word in object
     */
    public String getDefaultWord(){
        return mDefault;
    }


    /**
     * Gets image resource id
     * @return image resource id
     */
    public int getImgId(){  return mImgId;}

    /**
     * Returns whether or not there is an image for this view
     * @return true--> image exists, false--> image doesn't exist
     */
    public boolean hasImage(){
        return mImgId != NO_IMG_PROVIDED;
    }

    /**
     * Gets miwok pronunciation sound file resource ID
     * @return resource ID
     */
    public int getRawResourceId(){
        return mRawResourceId;
    }


 }
