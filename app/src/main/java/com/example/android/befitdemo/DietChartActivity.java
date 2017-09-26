package com.example.android.befitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.befitdemo.adapters.DietChartAdapter;

public class DietChartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);

        recyclerView = (RecyclerView)findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new DietChartAdapter();
        recyclerView.setAdapter(adapter);
    }
}
