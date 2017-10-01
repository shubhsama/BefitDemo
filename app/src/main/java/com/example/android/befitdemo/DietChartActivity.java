package com.example.android.befitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.befitdemo.adapters.DietChartAdapter;

import java.util.ArrayList;
import java.util.List;

public class DietChartActivity extends AppCompatActivity implements DietChartAdapter.CardClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<String> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);
        list.add("Pre BreakFast");
        list.add("BreakFast");
        list.add("Mid Morning");
        list.add("Lunch");
        list.add("Post Lunch");
        list.add("Dinner");

        recyclerView = (RecyclerView)findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new DietChartAdapter(list,DietChartActivity.this,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {

    }
}
