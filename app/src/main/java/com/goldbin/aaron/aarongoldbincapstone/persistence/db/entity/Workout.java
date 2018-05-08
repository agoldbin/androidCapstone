package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//@Parcel
@Getter
@Setter
@IgnoreExtraProperties
public class Workout implements Parcelable {

    int id;
    Date workoutDate;
    String workoutName;
    List<Exercise> exercises = new ArrayList<>();

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

    public Workout(Date workoutDate, String workoutName, ArrayList<Exercise> exercises) {
        this.workoutDate = workoutDate;
        this.workoutName = workoutName;
        this.exercises = exercises;
    }

    protected Workout(android.os.Parcel in) {
        id = in.readInt();
        workoutName = in.readString();
        exercises = in.createTypedArrayList(Exercise.CREATOR);
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(android.os.Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(workoutName);
        dest.writeTypedList(exercises);
    }
}
