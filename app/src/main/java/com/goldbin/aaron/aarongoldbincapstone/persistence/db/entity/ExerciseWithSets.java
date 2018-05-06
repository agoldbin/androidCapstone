package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ExerciseWithSets {
    @Embedded
    public Set set;
    @Relation(parentColumn = "id", entityColumn = "exerciseId", entity = Set.class)
    public List<Set> sets;

}
