package com.example.pixelhabit_attempt3;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream; // using this instead of FileWriter for compatibility
import java.io.IOException;
import java.util.ArrayList;

public class StorageManager {
    public void saveHabitList(ArrayList<Habit> list, Context context) {
        try {
            FileOutputStream writer = context.openFileOutput("habit_list", MODE_PRIVATE);

        } catch (IOException e) {
            Log.d("storage_manager", ("Save failed: " + e.getMessage()), e);
        }

    }
    public ArrayList<Habit> getHabitList() {
        return new ArrayList<Habit>();
    }
}
