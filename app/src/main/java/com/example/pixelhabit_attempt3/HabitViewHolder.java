package com.example.pixelhabit_attempt3;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

// This is a ViewHolder; stores references to parts of my habit.xml I want access to
public class HabitViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout background;
    private TextView streakNumber;
    private ImageView streakIcon;
    private ImageButton completeButton;
    private TextView name;
    private TextView description;

    public HabitViewHolder(View listItem) {
        super(listItem);

        background = (LinearLayout) listItem.findViewById(R.id.background); //
        streakNumber = (TextView) listItem.findViewById(R.id.streak_number);
        streakIcon = (ImageView) listItem.findViewById(R.id.streak_image);
        completeButton = (ImageButton) listItem.findViewById(R.id.donebutton);
        name = (TextView) listItem.findViewById(R.id.habit_name);
        description = (TextView) listItem.findViewById(R.id.habit_description);
    }

    public LinearLayout getBackground() {
        return background;
    } public TextView getStreakNumber() {
        return streakNumber;
    } public ImageView getStreakIcon() {
    return streakIcon;
    } public ImageButton getCompleteButton() {
        return completeButton;
    } public TextView getDescription() {
        return description;
    } public TextView getName() {
        return name;
    }
}
