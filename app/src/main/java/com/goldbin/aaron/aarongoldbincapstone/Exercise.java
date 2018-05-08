package com.goldbin.aaron.aarongoldbincapstone;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Basic java class for storing exercise info. Includes getters and setters to access data
 *
 * @author agoldbin
 */
@Getter
@Setter
// TODO load common exercises from StringArray?
public class Exercise implements Parcelable {


    // exercise name

    private String mExerciseName;

    // exercise sets
    // bool all sets same reps?
    private int mSets;

    // TODO add method to determine if reps or sets need to be int array (based on bools)

    // TODO one array/boolean and initialize twice?
    // TODO array or arraylist for reps and weights? should be equal to num of sets
    // TODO or use switch/if logic to determine inputs to display on screen? Likely need scrollview
    // exercise reps
    // bool all reps same?
    private ArrayList<Integer> mReps;
    private boolean repsSame;

    // bool all weights same?
    // exercise weight
    private ArrayList<Integer> mWeights;
    private boolean weightsSame;


     /**
      * Instantiates a new Exercise.
      *
      * @param exerciseName the exercise name
      * @param sets         the sets
      * @param reps         the reps
      * @param weights      the weights
      */
     public Exercise(String exerciseName, int sets, ArrayList reps, ArrayList weights) {
         mExerciseName = exerciseName;
         mSets = sets;
         mReps = reps;
         mWeights = weights;
     }

     /**
      * Instantiates a new Exercise.
      *
      * @param in the in
      */
     protected Exercise(Parcel in) {
         mExerciseName = in.readString();
         mSets = in.readInt();
         repsSame = in.readByte() != 0;
         weightsSame = in.readByte() != 0;
     }

     /**
      * The constant CREATOR.
      */
     public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
         @Override
         public Exercise createFromParcel(Parcel in) {
             return new Exercise(in);
         }

         @Override
         public Exercise[] newArray(int size) {
             return new Exercise[size];
         }
     };

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.mExerciseName);
         dest.writeInt(this.mSets);
         dest.writeArray(this.mReps.toArray());
         dest.writeArray(this.mWeights.toArray());
     }
 }
