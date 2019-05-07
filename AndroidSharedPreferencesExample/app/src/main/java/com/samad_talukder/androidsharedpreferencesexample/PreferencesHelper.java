package com.samad_talukder.androidsharedpreferencesexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesHelper {
    private final SharedPreferences mPreferences;
    public String NAME_KEY = "name";
    public static String MOBILE_KEY = "mobile_no";
    public static String EMAIL_KEY = "email";

    public PreferencesHelper(Context mContext) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void setNAME_KEY(String NAME_VALUE) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(NAME_KEY, NAME_VALUE);
        editor.apply();
    }

    public String getNAME_KEY() {
        return mPreferences.getString(NAME_KEY, "");
    }

    public void setStringPreferences(String key, String value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, value).apply();
    }

    public String getStringPreferences(String key) {
        return mPreferences.getString(key, "");
    }
    /**
     * This method is responsible to store data in SharedPreferences
     * */
    public void setIntPreferences(String key, int value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(key, value).apply();
    }

    /**
     * This method is responsible to retrieve data from SharedPreferences and display
     */
    public int getIntPreferences(String key) {
        return mPreferences.getInt(key, 0);
    }

    /**
     * This method is responsible to clear all data from SharedPreferences
     */
    public void clearPreferences() {
        try {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.clear().apply();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
