package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

// TODO https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#10 use this as model

import com.google.firebase.database.IgnoreExtraProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IgnoreExtraProperties
public class Exercise {
    private int id;
    private int workoutId;
    private String exerciseName;
    private int sets;
    private boolean repsSame;
    private boolean weightSame;

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
