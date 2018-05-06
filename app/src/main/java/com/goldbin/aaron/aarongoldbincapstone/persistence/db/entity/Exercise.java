package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

// TODO https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#10 use this as model

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "exercises",
        foreignKeys = {
                @ForeignKey(entity = Workout.class,
                        parentColumns = "id",
                        childColumns = "id",
                        onDelete = ForeignKey.CASCADE)
        })
public class Exercise {

    @PrimaryKey
    @NonNull
    private int id;

    @Relation(parentColumn = "id", entityColumn = "workoutId", entity = Exercise.class)
    private int workoutId;

    // exercise name
    @ColumnInfo(name = "exerciseName")
    private String exerciseName;

    // exercise sets
    @ColumnInfo(name = "sets")
    private int sets;

    @ColumnInfo(name = "repsSame")
    private boolean repsSame;

    @ColumnInfo(name = "weightsSame")
    private boolean weightSame;

    // Detailed info on sets
    @Embedded
    Set set;


    // TODO add method to determine if rep or sets need to be int array (based on bools)

    // TODO one array/boolean and initialize twice?
    // TODO array or arraylist for rep and weights? should be equal to num of sets
    // TODO or use switch/if logic to determine inputs to display on screen? Likely need scrollview

    /**
     * Instantiates a new Exercise entity.
     */
    public Exercise() {
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
        this.repsSame = repsSame;
        this.weightSame = weightSame;
    }
}
