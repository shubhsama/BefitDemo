package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;

import butterknife.BindView;

public class foodPreference extends AppCompatActivity {
double bmi;

    @BindView(R.id.veg)
    RadioButton veg;
    @BindView(R.id.nonveg)
    RadioButton nonveg;
    @BindView(R.id.next)
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_preference);

        Intent intent = getIntent();
        if(intent.hasExtra(Intent.EXTRA_TEXT)){
           bmi = Double.parseDouble(intent.getStringExtra(Intent.EXTRA_TEXT));
        }



    }

}
