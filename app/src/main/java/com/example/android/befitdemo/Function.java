package com.example.android.befitdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shubham on 25-09-2017.
 */

public class Function {
    public static String getName(Context context){
        String s="";
        SharedPreferences sh= context.getSharedPreferences("Name",Context.MODE_PRIVATE);
        sh.getString("DisplayName",s);
        return s;
    }
}
