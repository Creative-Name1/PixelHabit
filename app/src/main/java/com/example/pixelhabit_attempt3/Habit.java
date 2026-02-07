package com.example.pixelhabit_attempt3;

public class Habit {
    private String habitName;
    private String habitDesc;

    private int streak = 0;
    private boolean isStreakPositive = true;

    private int completionType;
    private int completionTypeUnit;
    private double min;
    private double max;

    // CONSTRUCTORS
    public Habit() {
        habitName = "Habit";
        habitDesc = "Example description text";
        completionType = 0;
        completionTypeUnit = 0;
        min = 0;
        max = 0;
    } public Habit(String name, String desc) {
        habitName = name;
        habitDesc = desc;
        completionType = 0;
        completionTypeUnit = 0;
        min = 0;
        max = 0;
    } public Habit(String name, String desc, int finType, int finUnit, int m, int mx) {
        habitName = name;
        habitDesc = desc;
        completionType = finType;
        completionTypeUnit = finUnit;
        min = m;
        max = mx;
    }

    // GET-INFO METHODS
    public String getName() {
        return habitName;
    } public String getDescription() {
        return habitDesc;
    } public int getStreak() {
        return streak;
    } public boolean getStreakPositive () {
        return isStreakPositive;
    } public int getCompletionType() {
        return completionType;
    } public int getCompletionTypeUnit() {
        return completionTypeUnit;
    } public double getMin() {
        return min;
    } public double getMax() {
        return max;
    }

    // SET-INFO METHODS
    public void setName(String name) {
        habitName = name;
    } public void setDescription(String desc) {
        habitDesc = desc;
    } public void setStreak(int s) {
        streak = s;
    } public void setStreakPositive(boolean p) {
        isStreakPositive = p;
    } public void setCompletionTypeUnit(int unit) {
        completionTypeUnit = unit;
    } public void setCompletionType(int type) {
        completionType = type;
    } public void setMin(double m) {
        min = m;
    } public void setMax(double m) {
        max = m;
    }

    public void setMinMax(double m, double mx, int unit) {
        completionTypeUnit = unit;
        min = m;
        max = mx;
    }

    public void toggleStreakPositive() {
        if (isStreakPositive) {
            isStreakPositive = false;
            return;
        }
        isStreakPositive = true;
    }

}
