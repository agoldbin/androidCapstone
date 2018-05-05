package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "exercises",
        foreignKeys = {
                @ForeignKey(entity = WorkoutEntity.class,
                        parentColumns = "id",
                        childColumns = "id",
                        onDelete = ForeignKey.CASCADE)
        })
public class ExerciseEntity implements Exercise {

    @PrimaryKey
    @NonNull
    private int id;

    // exercise name
    @ColumnInfo(name = "exercise_name")
    private String exerciseName;

    // exercise sets
    @ColumnInfo(name = "sets")
    private int sets;

    @ColumnInfo(name = "reps_same")
    private boolean repsSame;

    @ColumnInfo(name = "weight_same")
    private boolean weightSame;



    // TODO add method to determine if rep or sets need to be int array (based on bools)

    // TODO one array/boolean and initialize twice?
    // TODO array or arraylist for rep and weights? should be equal to num of sets
    // TODO or use switch/if logic to determine inputs to display on screen? Likely need scrollview
    // exercise rep
    // bool all rep same?
//    private ArrayList<Integer> mReps;
//    private boolean repsSame;
//
//    // bool all weights same?
//    // exercise weight
//    private ArrayList<Integer> mWeights;
//    private boolean weightsSame;


    /**
     * Instantiates a new Exercise entity.
     */
    public ExerciseEntity() {
    }

    /**
     * Instantiates a new Exercise.
     *
     * @param exerciseName the exercise name
     * @param sets         the sets
     */
    public ExerciseEntity(String exerciseName, int sets, boolean repsSame, boolean weightSame) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.repsSame = repsSame;
        this.weightSame = weightSame;
    }
}
