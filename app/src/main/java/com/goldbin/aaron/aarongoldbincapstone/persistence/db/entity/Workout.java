package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "workouts")
public class Workout {

    @PrimaryKey(autoGenerate = true)
    private int id;

    // date of workout
    @ColumnInfo(name = "workoutDate")
    Date workoutDate;

    // workout name/type(?)
    @ColumnInfo(name = "workoutName")
    String workoutName;

    // Exercises
    @Embedded
    Exercise exercise;

    public Workout() {
    }

    public Workout(String mWorkoutName) {
        this.workoutName = mWorkoutName;
        workoutDate = new Date();
    }
}
