package com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Workout;

import java.util.List;

@Dao
public interface ExerciseDao {
    @Insert
    void insertExercise (Exercise exercise);

    @Insert
    void insertExercises(List<Exercise> exerciseList);

    @Query("SELECT * FROM sets WHERE id = :id")
    Workout fetchOneWorkoutById(int id);

    @Update
    void updateWorkout (Workout workout);

    @Delete
    void deleteWorkout (Workout workout);
}