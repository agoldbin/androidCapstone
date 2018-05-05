package com.goldbin.aaron.aarongoldbincapstone.persistence.model;

/**
 * Basic java class for storing exercise info. Includes getters and setters to access data
 *
 * @author agoldbin
 */
// TODO load common exercises from StringArray?
public interface Exercise {
    int getId();
    String getExerciseName();
    int getSets();
    boolean isRepsSame();
    boolean isWeightSame();
}