package com.example.android.befitdemo.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.befitdemo.Functions;
import com.example.android.befitdemo.R;
import com.example.android.befitdemo.models.Details;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.android.befitdemo.Functions.databaseReference;
import static com.example.android.befitdemo.Functions.preference;

/**
 * Created by admin on 9/26/2017.
 */

public class DietChartAdapter extends RecyclerView.Adapter<DietChartAdapter.ChartViewHolder> {
    public List<String> list;
    Activity activity;
    CardClickListener cardClickListener;
    String uid= Functions.getUid();
     double bmi;

    String prefer,res="";
    DatabaseReference db= FirebaseDatabase.getInstance().getReference("Users").child(uid);
    DatabaseReference db2= FirebaseDatabase.getInstance().getReference("Charts");
    public DietChartAdapter(List<String> list, Activity activity, CardClickListener cardClickListener,String res,double bmi) {
        this.list = list;
        this.activity = activity;
        this.cardClickListener = cardClickListener;
        this.bmi=bmi;
        this.res=res;
    }

    @Override
    public DietChartAdapter.ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_list_item, parent, false);
        return new ChartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DietChartAdapter.ChartViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ChartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mealTimeTv;
        String cat = "",rest;

        public ChartViewHolder(View itemView) {
            super(itemView);
            mealTimeTv = (TextView) itemView.findViewById(R.id.meal_time);
            itemView.setOnClickListener(this);

        }

        public void setData(String s) {
            mealTimeTv.setText(s);
            mealTimeTv.setTextColor(Color.RED);



        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            cardClickListener.onItemClick(position);
            cat = mealTimeTv.getText().toString().toLowerCase();
            cat = cat.replaceAll("\\s+","");

            //Log.d("cat",cat);
            final Dialog dialog= new Dialog(activity);
            dialog.setContentView(R.layout.fragment_diet_chart_details);


            final TextView item= (TextView)dialog.findViewById(R.id.item);
            final TextView title= (TextView)dialog.findViewById(R.id.heading);

            Log.d("Meme", bmi+" " +res);
            db2.child(Functions.getBmiResultforFirebase(bmi)).child(res).child(cat).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    item.setText(dataSnapshot.getValue(String.class));
                    title.setText(mealTimeTv.getText().toString());
                    dialog.show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }
        public interface CardClickListener {
            void onItemClick(int position);
        }

}
