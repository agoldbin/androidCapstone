package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

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
    private int rep;
//    private boolean repsSame;

    // bool all weights same?
    // exercise weight
    private int weight;
//    private boolean weightsSame;
    public SetEntity(int rep, int weight) {
        this.rep = rep;
        this.weight = weight;
    }
}
