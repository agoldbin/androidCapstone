package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Workout;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "workouts")
public class WorkoutEntity implements Workout {

    @PrimaryKey(autoGenerate = true)
    private int id;

    // date of workout
    @ColumnInfo(name = "workout_date")
    Date workoutDate;

    // workout name/type(?)
    @ColumnInfo(name = "workout_name")
    String workoutName;

    public WorkoutEntity() {
    }

    public WorkoutEntity(String mWorkoutName) {
        this.workoutName = mWorkoutName;
        workoutDate = new Date();
    }
}
