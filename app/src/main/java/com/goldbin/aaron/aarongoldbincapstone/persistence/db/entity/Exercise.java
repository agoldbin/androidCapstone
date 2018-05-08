package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

// TODO https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#10 use this as model

import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import lombok.Getter;
import lombok.Setter;

//@Parcel
@Getter
@Setter
@IgnoreExtraProperties
public class Exercise implements Parcelable {
    int id;
    int workoutId;
    String exerciseName;
    int sets;
    int reps;
    int weight;


    // TODO add method to determine if rep or sets need to be int array (based on bools)

    // TODO one array/boolean and initialize twice?
    // TODO array or arraylist for rep and weights? should be equal to num of sets
    // TODO or use switch/if logic to determine inputs to display on screen? Likely need scrollview

    /**
     * Instantiates a new Exercise entity.
     */
    public Exercise() {
    }


    public Exercise(String exerciseName, int sets, int reps, int weight) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    /**
     * Instantiates a new Exercise entity.
     *
     * @param workoutId the workout id
     */
    public Exercise(int workoutId) {
    this.workoutId = workoutId;
    }

    /**
     * Instantiates a new Exercise.
     *
     * @param workoutId    the workout id
     * @param exerciseName the exercise name
     * @param sets         the sets
     * @param repsSame     the reps same
     * @param weightSame   the weight same
     */
    public Exercise(int workoutId, String exerciseName, int sets, boolean repsSame, boolean weightSame) {
        this.workoutId = workoutId;
        this.exerciseName = exerciseName;
        this.sets = sets;
    }

    protected Exercise(android.os.Parcel in) {
        id = in.readInt();
        workoutId = in.readInt();
        exerciseName = in.readString();
        sets = in.readInt();
        reps = in.readInt();
        weight = in.readInt();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(android.os.Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(workoutId);
        dest.writeString(exerciseName);
        dest.writeInt(sets);
        dest.writeInt(reps);
        dest.writeInt(weight);
    }
}
