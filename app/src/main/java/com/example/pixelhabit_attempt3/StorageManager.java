package com.example.pixelhabit_attempt3;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream; // using this instead of FileWriter for compatibility
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class StorageManager {
    Context context; // this will be whatever Activity made this

    public StorageManager(Context c) {
        context = c;
    }

    public void saveHabitList(ArrayList<Habit> toDoList, ArrayList<Habit> completeList) {
        try {
            Gson jsonConverter = new Gson();

            FileOutputStream fosIncomplete = context.openFileOutput("habit_list_incomplete.json", MODE_PRIVATE);
            PrintWriter pwIncomplete = new PrintWriter(fosIncomplete);

            FileOutputStream fosComplete = context.openFileOutput("habit_list_complete.json", MODE_PRIVATE);
            PrintWriter pwComplete = new PrintWriter(fosComplete);

            pwIncomplete.write(jsonConverter.toJson(toDoList));
            pwComplete.write(jsonConverter.toJson(completeList));

            pwComplete.close();
            pwIncomplete.close();
        } catch (IOException e) {
            Log.d("storage_manager", ("Save failed: " + e.getMessage()), e);
        }
    }

    public ArrayList<Habit> getCompleteHabitList() {
        try {
            Gson jsonInterpreter = new Gson();

            FileInputStream fis = context.openFileInput("habit_list_complete.json");
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(fis)); // inputstreamreader converts bytes to characters, bufferedreader converts characters to strings

            String outJson = "";

            // BufferedReader calls readline, keeps track of index on its own, returns null when the line DNE
            for (String outAdd = jsonReader.readLine(); // when initializing, we make a string outadd equal to the first line
                 outAdd != null; // bufferedreader returns null when there are no lines left to read
                 outAdd = jsonReader.readLine()) { // ofc we set outadd to the next line each repeat

                outJson += outAdd;
            }

            Type habitList = new TypeToken<ArrayList<Habit>>(){}.getType();
            return new ArrayList<Habit>(jsonInterpreter.fromJson(outJson, habitList));
        } catch (IOException e) {
            Log.d("storage_manager", ("Load failed: " + e.getMessage()), e);
            return new ArrayList<Habit>();
        }
    }
}
