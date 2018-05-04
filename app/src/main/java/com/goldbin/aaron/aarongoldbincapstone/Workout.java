package com.goldbin.aaron.aarongoldbincapstone;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListView;

import java.util.Date;

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

    // listview of workouts performed
    ListView mWorkoutListView;

    // workouts are editable

    // notes(?)
    String mWorkoutNotes;

    public Workout(String workoutName) {
        mWorkoutName = workoutName;
        mWorkoutDate = new Date();
    }

    protected Workout(Parcel in) {
        mWorkoutName = in.readString();
        mWorkoutNotes = in.readString();
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
        dest.writeString(mWorkoutNotes);
    }

    // store workouts to database(how?)
}
