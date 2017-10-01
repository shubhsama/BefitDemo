package com.example.android.befitdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.android.befitdemo.models.Details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.data;

/**
 * Created by Shubham on 25-09-2017.
 */

public class Functions {
    public static DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(Functions.getUid());
    public static DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference("Charts");
    private static double bmi;

    static String res ;
    public static String preference;
    public static String getName(Context context){
        String s="";
        SharedPreferences sh= context.getSharedPreferences("Name",Context.MODE_PRIVATE);
        s=sh.getString("DisplayName",s);
        return s;
    }
    public static String getBmiResult(double bmi) {
        String result;
        if (bmi < 18.9)
            result = "You are underweight.";
        else if (bmi > 18.9 && bmi < 24.9)
            result = "You are healthy.";
        else {
            result = "It seems you're overweight.";
        }
        return result;
    }
    public static String getBmiResultforFirebase(double bmi){
        String result;
        if (bmi < 18.9)
            result = "Underweight";
        else if (bmi > 18.9 && bmi < 24.9)
            result = "Normal";
        else {
            result = "Overweight";
        }
        return result;
    }
    public static double getBmi()
    {
        databaseReference.child("bmi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bmi = dataSnapshot.getValue(Double.class);
                Log.d("prefer",bmi+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return bmi;
    }



    public static String getUid()
    {
        FirebaseAuth auth= FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        return user.getUid();
    }
}
