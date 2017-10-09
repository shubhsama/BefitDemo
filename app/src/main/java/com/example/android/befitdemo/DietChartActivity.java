package com.example.android.befitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.befitdemo.adapters.DietChartAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DietChartActivity extends AppCompatActivity implements DietChartAdapter.CardClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<String> list= new ArrayList<>();
    String res="",prefer;
    static double bmi=0;
    String uid= Functions.getUid();
    DatabaseReference db= FirebaseDatabase.getInstance().getReference("Users").child(uid);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);
        prefer= getIntent().getStringExtra("Preference");
        Intent intent = getIntent();
        list.add("Pre Breakfast");
        list.add("Breakfast");
        list.add("Mid Morning");
        list.add("Lunch");
        list.add("Post Lunch");
        list.add("Dinner");
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            bmi = Double.parseDouble(intent.getStringExtra(Intent.EXTRA_TEXT));
        }

        if(prefer.equals("Vegetarian")) res="Veg";
        else res="NonVeg";

        recyclerView = (RecyclerView)findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new DietChartAdapter(list,DietChartActivity.this,this,res,bmi);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {

    }
}
