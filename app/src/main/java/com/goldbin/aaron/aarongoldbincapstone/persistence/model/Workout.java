package com.goldbin.aaron.aarongoldbincapstone.persistence.model;

import java.util.Date;

/**
 * Basic java class for storing workout info. Includes getters and setters to access data
 *
 * @author agoldbin
 */
public interface Workout {
    int getId();
    Date getWorkoutDate();
    String getWorkoutName();
}