package com.goldbin.aaron.aarongoldbincapstone;

/**
 * Interface to allow passing of data between activities and to save instance data
 *
 * @author agoldbin
 */

public interface AppInfo {
    public static final String FIREBASE_CHILD = "workouts";

    public static final String TAG
            = "myDebug";
    public static final String WORKOUT_LIST
            = "com.goldbin.aaron.aarongoldbincapstone.persistence.ui.MainActivity";
    public static final String EXERCISE_LIST
            = "com.goldbin.aaron.aarongoldbincapstone.persistence.ui.WorkoutActivity";
    public static final String EXERCISES
            = "com.goldbin.aaron.aarongoldbincapstone.ExerciseAcitivty";
    public static final String EDIT_WORKOUT
            = "com.goldbin.aaron.aarongoldbincapstone.editWorkout";
    public static final String EDIT_EXERCISE
            = "com.goldbin.aaron.aarongoldbincapstone.editExercise";
    public static final String EXTRA_WORKOUT_ADDED
            = "com.goldbin.aaron.aarongoldbincapstone.addWorkout";
    public static final String UPDATE_WORKOUT
            = "com.goldbin.aaron.aarongoldbincapstone.updateWorkout";

    // Exercise Activity vars
    public static final String NAME
        = "com.goldbin.aaron.aarongoldbincapstone.exerciseName";
    public static final String SET
            = "com.goldbin.aaron.aarongoldbincapstone.sets";
    public static final String REP
            = "com.goldbin.aaron.aarongoldbincapstone.rep";
    public static final String WEIGHT
            = "com.goldbin.aaron.aarongoldbincapstone.weight";
    public static final String REP_BOOL
            = "com.goldbin.aaron.aarongoldbincapstone.repBool";
    public static final String WEIGHT_BOOL
            = "com.goldbin.aaron.aarongoldbincapstone.weightBool";

}
