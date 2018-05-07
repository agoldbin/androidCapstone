package com.goldbin.aaron.aarongoldbincapstone;

/**
 * Interface to allow passing of data between activities and to save instance data
 *
 * @author agoldbin
 */

public interface AppInfo {
    public static final String APP_PATH = "com.goldbin.aaron.aarongoldbincapstone";
    public static final String TAG = "myDebug";
    public static final String WORKOUT_LIST
            = APP_PATH + ".MainActivity";
    public static final String EXERCISE_LIST
            = APP_PATH + ".WorkoutActivity";
    public static final String EXERCISES
            = APP_PATH + ".ExerciseAcitivty";
    public static final String EDIT_WORKOUT
            = APP_PATH + ".editWorkout";
    public static final String EDIT_EXERCISE
            = APP_PATH + ".editExercise";


    // Exercise Activity vars
    public static final String NAME
        = APP_PATH + ".exerciseName";
    public static final String SET
            = APP_PATH + ".sets";
    public static final String REP
            = APP_PATH + ".reps";
    public static final String WEIGHT
            = APP_PATH + ".weight";
    public static final String REP_BOOL
            = APP_PATH + ".repBool";
    public static final String WEIGHT_BOOL
            = APP_PATH + ".weightBool";

}
