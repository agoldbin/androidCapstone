package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Exercise;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "sets",
        foreignKeys = {
                @ForeignKey(entity = ExerciseEntity.class,
                        parentColumns = "id",
                        childColumns = "id",
                        onDelete = ForeignKey.CASCADE)
        })
public class SetEntity {
    @PrimaryKey
    @NonNull
    private int id;

//     exercise rep
//     bool all rep same?
    @Relation(parentColumn = "sets", entityColumn = "exerciseId", entity = Exercise.class)
    private List<Integer> rep;
//    private boolean repsSame;

    // bool all weights same?
    // exercise weight
    @Relation(parentColumn = "sets", entityColumn = "exerciseId", entity = Exercise.class)
    private List<Integer> weight;
//    private boolean weightsSame;

    public SetEntity(List<Integer> rep, List<Integer> weight) {
        this.rep = rep;
        this.weight = weight;
    }
}
