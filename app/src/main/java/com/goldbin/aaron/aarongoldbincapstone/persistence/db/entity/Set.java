package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Set.
 */
@Getter
@Setter
@Entity(tableName = "sets",
        foreignKeys = {
                @ForeignKey(entity = Exercise.class,
                        parentColumns = "id",
                        childColumns = "exerciseId",
                        onDelete = ForeignKey.CASCADE)
        })
public class Set {
    @PrimaryKey
    @NonNull
    private int id;

//    @ColumnInfo(name = "exercise_id")
    @Relation(parentColumn = "id", entityColumn = "exerciseId", entity = Set.class)
    private int exerciseId;

//     exercise rep
//     bool all rep same?
    @ColumnInfo(name = "rep")
    private int rep;
//    private boolean repsSame;

    // bool all weights same?
    // exercise weight
    @ColumnInfo(name = "weight")
    private int weight;
//    private boolean weightsSame;

    /**
     * Instantiates a new Set.
     *
     * @param rep    the rep
     * @param weight the weight
     */
    public Set(int rep, int weight) {
        this.rep = rep;
        this.weight = weight;
    }

    /**
     * Instantiates a new Set.
     */
    public Set() {
    }

    /**
     * Instantiates a new Set.
     *
     * @param exerciseId the exercise id
     */
    public Set(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    /**
     * Instantiates a new Set.
     *
     * @param id         the id
     * @param exerciseId the exercise id
     * @param rep        the rep
     * @param weight     the weight
     */
    public Set(@NonNull int id, int exerciseId, int rep, int weight) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.rep = rep;
        this.weight = weight;
    }
}
