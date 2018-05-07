package com.goldbin.aaron.aarongoldbincapstone;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.goldbin.aaron.aarongoldbincapstone.model.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.model.Workout;

@Database(entities = {Workout.class, Exercise.class}, version = 1)
public abstract class AGoldbinDB extends RoomDatabase {

    public abstract WorkoutDao WorkoutDao();
    public abstract ExerciseDao ExerciseDao();

}
