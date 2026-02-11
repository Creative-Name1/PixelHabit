package com.example.pixelhabit_attempt3;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditHabitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_habit_screen);
        View UI = findViewById(R.id.edit_habit_screen); //

        //define UI
        ImageButton backButton = UI.findViewById(R.id.back_button);
        EditText nameSetter = UI.findViewById(R.id.name_setter);
        EditText descSetter = UI.findViewById(R.id.desc_setter);
        TextView finTypeText = UI.findViewById(R.id.completion_type);
        LinearLayout editButton = UI.findViewById(R.id.edit_button);
        LinearLayout minMaxLayout = UI.findViewById(R.id.min_max_info);
        TextView minInfo = UI.findViewById(R.id.min_info);
        TextView maxInfo = UI.findViewById(R.id.max_info);

        // get and define data from the Intent that was given
        Intent hData = getIntent();
        String name = hData.getStringExtra("habit_name");
        String description = hData.getStringExtra("habit_description");
        int completionType = hData.getIntExtra("completion_type", 0);
        int completionUnit = hData.getIntExtra("completion_unit", 0);
        double min = hData.getDoubleExtra("min", 0);
        double max = hData.getDoubleExtra("min", 0);

        // fill out UI with new info
        nameSetter.setText(name);
        descSetter.setText(description);
        String typeName = "Standard";
        if (completionType == 0) { // completionType of 0 =
            minMaxLayout.setVisibility(View.GONE); // gets rid of minmax text entirely
        } else if (completionType == 1) {
            typeName = "MinMax";
            minInfo.setText(String.valueOf(min));
            maxInfo.setText(String.valueOf(max));
        }
        finTypeText.setText("Completion Type: " + typeName);

    }
}
