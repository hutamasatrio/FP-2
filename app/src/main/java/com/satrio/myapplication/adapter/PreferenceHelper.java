package com.satrio.myapplication.adapter;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static PreferenceHelper INSTANCE;
    private SharedPreferences sharedPreferences;

    private PreferenceHelper(Context context){
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("simple.android.app", Context.MODE_PRIVATE);
    }

    public static PreferenceHelper getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new PreferenceHelper(context);
        }
        return INSTANCE;
    }

    public SharedPreferences Pref(){
        return sharedPreferences;
    }
    public Boolean isLogin(){
        return sharedPreferences.getBoolean("isLogin", false);
    }
    public void setLogin(Boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin", isCall).apply(); }

    public void setName(String isName){
        sharedPreferences.edit().putString("isName", isName).apply();}

    public String getName(){
        return sharedPreferences.getString("isName", " ");
    }


    public void setPass(String isPass){
        sharedPreferences.edit().putString("isPass", isPass).apply();}

    public String getPass(){
        return sharedPreferences.getString("isPass", " ");
    }


    public void setEmail(String isEmail){
        sharedPreferences.edit().putString("isEmail", isEmail).apply();}

    public String getEmail(){
        return sharedPreferences.getString("isEmail", " ");
    }
}
