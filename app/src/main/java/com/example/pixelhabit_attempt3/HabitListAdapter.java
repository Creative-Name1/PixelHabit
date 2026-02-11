package com.example.pixelhabit_attempt3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater; // external class that can inflate(make a View object copy of) my habit.xml
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HabitListAdapter extends RecyclerView.Adapter<HabitViewHolder> {
    private Habit[] habitList;

    public HabitListAdapter(Habit[] list) {
        habitList = list;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // triggers whenever my RecyclerView needs a new ViewHolder; creates new HabitViewGroup
        View habitView = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit, parent, false); // make a new View object from my habit.xml
        return new HabitViewHolder(habitView);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        Habit h = habitList[position]; // get data for the current habit

        // inputting data into the view
        holder.setStreakNumber(h.getStreak());
        holder.setStreakPositivity(h.getStreakPositive());
        holder.setName(h.getName()); // ex. we want habit-specific names
        holder.setDescription(h.getDescription());

        // setting onClickListeners for the specific habit's background and complete button
        holder.getBackground().setOnClickListener(v ->{
            Log.d("ONCLICK", ("Backround was clicked! ID:" + position));
            Intent intent = new Intent(v.getContext(), EditHabitActivity.class);
            // "from: MainActivity, to:EditHabitActivity"

            intent.putExtra("habit_name", h.getName());
            intent.putExtra("habit_description", h.getDescription());
            intent.putExtra("completion_type", h.getCompletionType());
            intent.putExtra("completion_unit", h.getCompletionTypeUnit());
            intent.putExtra("min", h.getMin());
            intent.putExtra("max", h.getMax());

            v.getContext().startActivity(intent);
        });
        holder.getCompleteButton().setOnClickListener(v ->{
            Log.d("ONCLICK", ("Complete Button was clicked! ID:" + position));
        });
    }

    @Override
    public int getItemCount() {
        return habitList.length;
    }
}
