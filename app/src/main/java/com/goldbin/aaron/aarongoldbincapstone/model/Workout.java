package com.goldbin.aaron.aarongoldbincapstone.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

/**
 * Basic java class for storing workout info. Includes getters and setters to access data
 *
 * @author agoldbin
 */
@Entity(tableName = "workouts")
@Getter
@Setter
public class Workout implements Parcelable {

    @PrimaryKey
    // date of workout
    Date mWorkoutDate;

    // workout name/type(?)
    String mWorkoutName;

    // workouts are editable

    public Workout(String workoutName) {
        mWorkoutName = workoutName;
        SimpleDateFormat mWorkoutDate = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
        System.out.println(mWorkoutDate);
    }

    protected Workout(Parcel in) {
        mWorkoutName = in.readString();
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mWorkoutName);
    }
}
