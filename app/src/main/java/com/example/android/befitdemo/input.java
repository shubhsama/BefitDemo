package com.example.android.befitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class input extends AppCompatActivity {

    @BindView(R.id.age_edit)
    EditText ageEdit;
    @BindView(R.id.weight_edit)
    EditText weightEdit;
    @BindView(R.id.height_edit_text)
    EditText heightEdit;
    @BindView(R.id.button_next)
    Button buttonNext;
    int a;
    double w;
    double h,bmi;
    DatabaseReference db;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);
        auth=FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance().getReference().child("Users").child(auth.getCurrentUser().getUid());

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a= Integer.parseInt(ageEdit.getText().toString());
                w= Double.parseDouble(weightEdit.getText().toString());
                h=Double.parseDouble(heightEdit.getText().toString());
                bmi= w/((h*h)/10000);
                if((bmi+"").length()>=5)
                    bmi=Double.parseDouble((bmi+"").substring(0,5));
                Users u= new Users(Functions.getName(getApplicationContext()),a,w,h,bmi);
                db.setValue(u);
                Intent intent= new Intent(getApplicationContext(),BmiResult.class);
                intent.putExtra("Bmi",bmi+"");
                startActivity(intent);

            }
        });
    }
}
