package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IgnoreExtraProperties
public class Workout {

    private int id;
    private Date workoutDate;
    private String workoutName;
    private ArrayList<Exercise> exercises;

    public Workout() {
    }

    public Workout(String workoutName) {
        this.workoutName = workoutName;
        workoutDate = new Date();
        this.exercises = exercises;
    }

    public Workout(String workoutName, ArrayList<Exercise> exercises) {
        this.workoutName = workoutName;
        workoutDate = new Date();
        this.exercises = exercises;
    }
}
