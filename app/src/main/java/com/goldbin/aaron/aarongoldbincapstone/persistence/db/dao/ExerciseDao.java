package com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExerciseDao {
    @Insert
    void insertExercise (Exercise exercise);

    @Insert
    void insertExercises(List<Exercise> exerciseList);

    @Query("SELECT * FROM exercises WHERE id = :id")
    Workout fetchOneWorkoutById(int id);

    @Query("SELECT * FROM exercises")
    ArrayList<Exercise> getAllExercises();

    @Update
    void updateExercise (Exercise exercise);

    @Delete
    void deleteWo(Exercise exercise);
}
