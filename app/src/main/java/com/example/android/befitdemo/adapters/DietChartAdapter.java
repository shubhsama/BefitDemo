package com.example.android.befitdemo.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.befitdemo.R;

/**
 * Created by admin on 9/26/2017.
 */

public class DietChartAdapter extends RecyclerView.Adapter<DietChartAdapter.ChartViewHolder> {

    public DietChartAdapter(){

    }
    @Override
    public DietChartAdapter.ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_list_item, parent, false);
        return new ChartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DietChartAdapter.ChartViewHolder holder, int position) {
        holder.mealTimeTv.setText("Dummy data");
        holder.mealTimeTv.setTextColor(Color.RED);

        holder.itemOne.setText("Laude le le");
        holder.itemOne.setTextColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return 6;
    }
    class ChartViewHolder extends RecyclerView.ViewHolder {
        TextView mealTimeTv, itemOne, itemTwo;

        public ChartViewHolder(View itemView) {
            super(itemView);
            mealTimeTv = (TextView)itemView.findViewById(R.id.meal_time);
            itemOne = (TextView)itemView.findViewById(R.id.mel_item_one);
        }
    }
}
