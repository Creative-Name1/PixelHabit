package com.example.pixelhabit_attempt3;

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
        Habit h = habitList[position];
        holder.setStreakNumber(h.getStreak());
        holder.setStreakPositivity(h.getStreakPositive());
        holder.setName(h.getName());
        holder.setDescription(h.getDescription());
    }

    @Override
    public int getItemCount() {
        return habitList.length;
    }
}
