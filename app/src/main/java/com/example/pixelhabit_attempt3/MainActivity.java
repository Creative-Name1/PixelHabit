package com.example.pixelhabit_attempt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList; // habit list

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView; // for scrollable list of habits

public class MainActivity extends AppCompatActivity {
    // These are for part of the UI; whether or not certain habit lists are visible.
    private boolean todoOpen = true;
    private boolean doneOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StorageManager s = new StorageManager(this);

        ArrayList<Habit> completeHabitList = s.getCompleteHabitList();
        ArrayList<Habit> incompleteHabitList = s.getCompleteHabitList();

        Habit[] completedHabitArray = completeHabitList.toArray(new Habit[0]);
        Habit[] incompleteHabitArray = incompleteHabitList.toArray(new Habit[0]);

        setContentView(R.layout.habit_list);

        // init. todo recyclerview
        RecyclerView incompleteListView = findViewById(R.id.incomplete_habit_list); // now that we have a file set this knows what file to search
        HabitListAdapter incompleteListAdapter = new HabitListAdapter(incompleteHabitArray);
        incompleteListView.setAdapter(incompleteListAdapter);
        incompleteListView.setLayoutManager(new LinearLayoutManager(this));

        // init. done recyclerview
        RecyclerView completeListView = findViewById(R.id.complete_habit_list); // now that we have a file set this knows what file to search
        HabitListAdapter completeListAdapter = new HabitListAdapter(completedHabitArray);
        completeListView.setAdapter(completeListAdapter);
        completeListView.setLayoutManager(new LinearLayoutManager(this));




        // [UI BUTTONS SECTION]
        LinearLayout todoToggle = findViewById(R.id.todo_togglebutton); // init. view objects
        LinearLayout doneToggle = findViewById(R.id.done_togglebutton); // for toggles
        ImageView todoArrow = findViewById(R.id.todo_arrow);
        ImageView doneArrow = findViewById(R.id.done_arrow);

        // OnClickListeners for whether certain lists are visible
        todoToggle.setOnClickListener(v -> {
            if (todoOpen) {
                incompleteListView.setVisibility(View.GONE);
                todoArrow.setImageResource(R.drawable.arrow_closed);
            } else {
                incompleteListView.setVisibility(View.VISIBLE);
                todoArrow.setImageResource(R.drawable.arrow_open);
            }
            todoOpen = !todoOpen;
        });
        doneToggle.setOnClickListener(v -> {
            if (doneOpen) {
                completeListView.setVisibility(View.GONE);
                doneArrow.setImageResource(R.drawable.arrow_closed);
            } else {
                completeListView.setVisibility(View.VISIBLE);
                doneArrow.setImageResource(R.drawable.arrow_open);
            }
            doneOpen = !doneOpen;
        });
        // [UI BUTTONS SECTION]

//      // [HANDLE INTENT FROM EDITHABIT ACTIVITY]
//        Intent editHabitData = getIntent();
//        if (editHabitData.getBooleanExtra("edits_were_made", false)) {
//            Habit h = habitList.get(editHabitData.getIntExtra("index", 0));
//
//            h.setName(editHabitData.getStringExtra("name"));
//            h.setDescription(editHabitData.getStringExtra("description"));
//        }
//        // [HANDLE INTENT FROM EDITHABIT ACTIVITY]

    }
}