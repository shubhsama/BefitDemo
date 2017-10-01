package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BmiResult extends AppCompatActivity {
    double bmi;
    @BindView(R.id.bmi_text)
    TextView bmiText;
    @BindView(R.id.bmi_info)
    TextView bmiInfo;
    @BindView(R.id.next)
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        ButterKnife.bind(this);
        bmi = Double.parseDouble(getIntent().getStringExtra("Bmi"));
        if((bmi+"").length()>=5)
            bmiText.setText((bmi+"").substring(0,5));
        bmiInfo.setText(Functions.getBmiResult(bmi));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BmiResult.this, foodPreference.class);
                intent.putExtra(Intent.EXTRA_TEXT, bmi+"");
                startActivity(intent);
            }
        });

    }
}
