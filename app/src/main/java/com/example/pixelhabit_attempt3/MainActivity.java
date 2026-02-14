package com.example.pixelhabit_attempt3;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList; // habit list

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView; // for scrollable list of habits

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Habit> habitList = new ArrayList<Habit>();

        // [TESTING JUNK]
        habitList.add(new Habit());
        habitList.add(new Habit("Cool habit name", "this is a description"));
        habitList.add(new Habit("Meditate twice daily", "Who could possibly set this habit", 1, 0, 2, 12));
        habitList.add(new Habit());
        habitList.add(new Habit("Eat 4-5 dozen eggs a day", "(No description)"));
        habitList.add(new Habit());
        habitList.add(new Habit());
        habitList.add(new Habit("Make sure to drink 6-7 glasses of water a day to stay tuff", "(no description)", 1, 0, 6, 7));
        habitList.add(new Habit("Run a 15k every morning", "or at least 7k"));
        habitList.add(new Habit());
        habitList.get(1).setStreak(2);
        habitList.get(2).setStreakPositive(false);
        habitList.get(2).setStreak(4);
        habitList.get(4).setStreak(7);
        habitList.get(5).setStreakPositive(false);
        habitList.get(5).setStreak(1);
        habitList.get(6).setStreakPositive(false);
        habitList.get(6).setStreak(2);
        habitList.get(7).setStreak(17);
        habitList.get(8).setStreakPositive(false);
        habitList.get(8).setStreak(2147483647);
        // [TESTING JUNK]






        // [HANDLE INTENT FROM EDITHABIT ACTIVITY]
        Intent editHabitData = getIntent();
        if (editHabitData.getBooleanExtra("edits_were_made", false)) {
            Habit h = habitList.get(editHabitData.getIntExtra("index", 0));

            h.setName(editHabitData.getStringExtra("name"));
            h.setDescription(editHabitData.getStringExtra("description"));
        }
        // [HANDLE INTENT FROM EDITHABIT ACTIVITY]



        Habit[] habitArray = habitList.toArray(new Habit[0]);

        setContentView(R.layout.habit_list);

        RecyclerView recyclerView = findViewById(R.id.habit_list); // now that we have a file set this knows what file to search
        HabitListAdapter listAdapter = new HabitListAdapter(habitArray);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}