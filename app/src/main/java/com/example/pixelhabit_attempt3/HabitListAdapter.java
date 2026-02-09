package com.example.pixelhabit_attempt3;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HabitListAdapter extends RecyclerView.Adapter<> {
    private Habit[] habitList;

    public HabitListAdapter(Habit[] list) {
        habitList = list;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // triggers whenever my RecyclerView needs a new ViewHolder; creates new HabitViewGroup

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
