package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.befitdemo.R.id.proceed;

public class foodPreference extends AppCompatActivity {
    double bmi;

    @BindView(R.id.radiogroup)
    RadioGroup radioGroup;
    RadioButton radioButton;
    @BindView(R.id.proceed)
    Button proceed;
    FirebaseAuth auth;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_preference);
        ButterKnife.bind(this);
        auth= FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());
        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            bmi = Double.parseDouble(intent.getStringExtra(Intent.EXTRA_TEXT));
        }

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(id);
                db.child("preference").setValue(radioButton.getText().toString());
                Intent intent = new Intent(foodPreference.this, DietChartActivity.class);
                startActivity(intent);
            }
        });


    }

}
