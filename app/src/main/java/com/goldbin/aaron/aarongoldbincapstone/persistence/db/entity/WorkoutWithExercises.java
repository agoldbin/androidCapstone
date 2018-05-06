package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class WorkoutWithExercises {
    @Embedded
    public Workout workout;
    @Relation(parentColumn = "id", entityColumn = "workoutId", entity = Exercise.class)
    public List<ExerciseWithSets> exercises;
}
