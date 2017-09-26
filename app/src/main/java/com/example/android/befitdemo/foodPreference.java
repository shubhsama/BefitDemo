package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class foodPreference extends AppCompatActivity {
    double bmi;

    @BindView(R.id.veg)
    RadioButton veg;
    @BindView(R.id.nonveg)
    RadioButton nonveg;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.proceed)
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_preference);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            bmi = Double.parseDouble(intent.getStringExtra(Intent.EXTRA_TEXT));
        }

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodPreference.this, DietChartActivity.class);
                startActivity(intent);
            }
        });


    }

}
