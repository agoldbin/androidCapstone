package com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity;

import com.google.firebase.database.IgnoreExtraProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Set.
 */
@Getter
@Setter
@IgnoreExtraProperties
public class Set {
    private int id;
    private int exerciseId;
    private int rep;
    private int weight;


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
    public Set(int id, int exerciseId, int rep, int weight) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.rep = rep;
        this.weight = weight;
    }
}
