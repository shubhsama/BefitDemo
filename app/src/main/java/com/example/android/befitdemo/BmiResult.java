package com.example.android.befitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BmiResult extends AppCompatActivity {
    double bmi;
    @BindView(R.id.bmi_text)
    TextView bmiText;
    @BindView(R.id.bmi_info)
    TextView bmiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        ButterKnife.bind(this);
        bmi = Double.parseDouble(getIntent().getStringExtra("Bmi"));

        bmiText.setText((bmi+"").substring(0,5));
        if(bmi<18.9)
            bmiInfo.setText("You are underweight.");
        else
            if(bmi>18.9&&bmi<24.9)
                bmiInfo.setText("You are healthy.");
        else{
                bmiInfo.setText("It seems you're overweight.");
            }

    }
}
