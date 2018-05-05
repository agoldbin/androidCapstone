package com.goldbin.aaron.aarongoldbincapstone.persistence.ui;

import android.arch.lifecycle.BuildConfig;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.goldbin.aaron.aarongoldbincapstone.AppInfo;
import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.R;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements AppInfo {

    // instantiate widgets
    Button mAddButton;
    Button mCancelButton;
    EditText mEx1;
    EditText mEx2;
    EditText mName;
    EditText mSets;
    EditText mRep;
    EditText mWeight;
    Switch mRepBool;
    Switch mWeightBool;
    String mLblChange;
    TextView mLblName;
    TextView mLblSets;
    TextView mLblReps;
    TextView mLblWeights;
    ArrayList<Integer> mExerciseReps = new ArrayList<>();
    ArrayList<Integer> mExerciseWeights = new ArrayList<>();


    // instantiate Contact so constructor can be accessed
    Exercise mExercise;


    /* (non-Javadoc)
     * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onSaveInstanceState");
        }
//        TODO set/rep/weight, putArrayList?
        savedInstanceState.putString(NAME, mName.getText().toString());
        savedInstanceState.putString(SET, mSets.getText().toString());
        savedInstanceState.putString(REP, mRep.getText().toString());
        savedInstanceState.putString(WEIGHT, mWeight.getText().toString());
    }


    /*
     * If restoring instance, set information passed from saved instance
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onRestoreInstanceState");
        }
        // Using one string to set all text areas
        String mCurrentString;
        boolean mBool;

        mCurrentString = savedInstanceState.getString(NAME);
        mName.setText(mCurrentString);

        mCurrentString = savedInstanceState.getString(SET);
        mSets.setText(mCurrentString);

        mCurrentString = savedInstanceState.getString(REP);
        mRep.setText(mCurrentString);

        mCurrentString = savedInstanceState.getString(WEIGHT);
        mWeight.setText(mCurrentString);

        mBool = savedInstanceState.getBoolean(REP_BOOL);
        mRepBool.setChecked(mBool);

        mBool = savedInstanceState.getBoolean(WEIGHT_BOOL);
        mWeightBool.setChecked(mBool);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // wire up widgets
        mAddButton = (Button) (findViewById(R.id.btnAdd));
        mCancelButton = (Button) (findViewById(R.id.btnCancel));
        mName = (EditText) (findViewById(R.id.inputExerciseName));
        mSets = (EditText) (findViewById(R.id.inputExerciseSets));
        mRep = (EditText) (findViewById(R.id.inputExerciseReps));
        mWeight = (EditText) (findViewById(R.id.inputExerciseWeight));
        mRepBool = (Switch) (findViewById(R.id.switchReps));
        mWeightBool = (Switch) (findViewById(R.id.switchWeight));
        mLblName = (TextView) (findViewById(R.id.lblExerciseName));
        mLblSets = (TextView) (findViewById(R.id.lblExerciseSets));
        mLblReps = (TextView) (findViewById(R.id.lblExerciseReps));
        mLblWeights = (TextView) (findViewById(R.id.lblExerciseWeights));
//        mLbl1 = (TextView) (findViewById(R.id.lblExercise1));
//        mLbl2 = (TextView) (findViewById(R.id.lblExercise2));


        // check for contact being passed to activity
        Intent intent = getIntent();
        if (intent.hasExtra("EDIT_EXERCISE")) {
            mExercise = intent.getParcelableExtra("EDIT_EXERCISE");
            mName.setText(mExercise.getMExerciseName());
            mSets.setText(mExercise.getMSets());
//            mRep.setText(mExercise.getRep().toString());
//            mWeight.setText(mExercise.getWeights().toString());
            mRepBool.setChecked(mExercise.isRepsSame());
            mWeightBool.setChecked(mExercise.isWeightsSame());
            mAddButton.setText(R.string.update);
        }

        // cancel button pressed
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // add button pressed
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verify that mFirst && mLast HAVE BEEN ENTERED BEFORE BEING PASSED
                if (mName.getText().toString().trim().equalsIgnoreCase("")) {
                    mName.setError("Exercise name is required");
                } else if (mSets.getText().toString().trim().equalsIgnoreCase("")) {
                    mSets.setError("# of sets is required");
                }

//                checkSwitches();
                toggleScreenView();

//                else if (mExercise != null) {
//                if (mExercise != null) {
//                    mExercise.setExerciseName(mName.getText().toString());
//                    mExercise.setSets(Integer.parseInt(mSets.getText().toString()));
//                    mExercise.setRep(mExerciseReps);
//                    mExercise.setWeights(mExerciseWeights);
//
//                    exerciseUpdated();
//                    ExerciseActivity.super.onBackPressed();
//                } else {
//                    mExercise = new Exercise(
//                            mName.getText().toString()
//                            , Integer.parseInt(mSets.getText().toString())
//                            , mExerciseReps
//                            , mExerciseWeights
//                    );
//                    exerciseEntered();
//                    ExerciseActivity.super.onBackPressed();
            }
        });
    }


    // put exercise info into extra to be passed to first activity
    public void exerciseEntered () {
        Intent exerciseData = new Intent(ExerciseActivity.this, WorkoutActivity.class);
        exerciseData.putExtra("EXTRA_EXERCISE_ADDED", (Parcelable) mExercise);
        setResult(0, exerciseData);
    }

    // put exercise info into extra to be passed to first activity
    public void exerciseUpdated () {
        Intent exerciseData = new Intent(ExerciseActivity.this, WorkoutActivity.class);
        exerciseData.putExtra("UPDATE_EXERCISE", (Parcelable) mExercise);
        setResult(2, exerciseData);
    }

    // function to determine if switches are activated
    public void checkSwitches () {
        int i = 1;
        if (mRepBool.isChecked()) {
            if (mWeightBool.isChecked()) {
                // all sets same rep and weight
                // on click, exercise done!
            } else {
                // all sets same rep, different weights
                while (i <= mExercise.getMSets()) {
                    if (i > 1) {
                        // set and default input for sets
                        mEx1.setFocusable(false);
                        mEx1.setText(mExercise.getMReps().get(i - 1));
                    }
                    // onclick, add weight to arraylist
                    mAddButton.setText(R.string.add_set + i);
                    mAddButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // verify that mFirst && mLast HAVE BEEN ENTERED BEFORE BEING PASSED
                            if (mEx1.getText().toString().trim().equalsIgnoreCase("")) {
                                mEx1.setError("# of rep required");
                            } else if (mEx2.getText().toString().trim().equalsIgnoreCase("")) {
                                mEx2.setError("Weight required");
                            }
                            mExerciseReps.add(Integer.parseInt(mEx1.getText().toString()));
                            mExerciseWeights.add(Integer.parseInt(mEx2.getText().toString()));
                        }
                    });
                    i++;
                }
            }
            mExercise.setMWeights(mExerciseWeights);
        } else {
            if (mWeightBool.isChecked()) {
                // all sets different rep, same weight

            } else {
                // all sets are different rep and weights
            }
        }
    }

    public void setArrayLists () {
        int i = 1;
        while (i <= mExercise.getMSets()) {
            if (i > 1) {
                // set and default input for weights
                mEx2.setFocusable(false);
                mEx2.setText(mExercise.getMWeights().get(i - 1));
            }
            // onclick, add weight to arraylist
            mAddButton.setText(R.string.add_set + i);
            mAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // verify that mFirst && mLast HAVE BEEN ENTERED BEFORE BEING PASSED
                    if (mEx1.getText().toString().trim().equalsIgnoreCase("")) {
                        mEx1.setError("# of rep required");
                    } else if (mEx2.getText().toString().trim().equalsIgnoreCase("")) {
                        mEx2.setError("Weight required");
                    }
                    mExerciseReps.add(Integer.parseInt(mEx1.getText().toString()));
                    mExerciseWeights.add(Integer.parseInt(mEx2.getText().toString()));
                }
            });
            i++;
        }
    }

    /**
     * This method will determine what text and edit views to display on the activity
     */
    public void toggleScreenView () {
        if (mName.getVisibility() == View.VISIBLE) {
            mName.setVisibility(View.GONE);
            mSets.setVisibility(View.GONE);
            mLblName.setVisibility(View.GONE);
            mLblSets.setVisibility(View.GONE);

            mLblReps.setVisibility(View.VISIBLE);
            mLblWeights.setVisibility(View.VISIBLE);
            mWeight.setVisibility(View.VISIBLE);
            mSets.setVisibility(View.VISIBLE);
        } else {
            mName.setVisibility(View.VISIBLE);
            mSets.setVisibility(View.VISIBLE);
            mLblName.setVisibility(View.VISIBLE);
            mLblSets.setVisibility(View.VISIBLE);

            mLblReps.setVisibility(View.GONE);
            mLblWeights.setVisibility(View.GONE);
            mWeight.setVisibility(View.GONE);
            mSets.setVisibility(View.GONE);
        }
    }

    // back to home screen if back or cancel buttons pressed
    @Override
    public void onBackPressed () {
        super.onBackPressed();
    }
}