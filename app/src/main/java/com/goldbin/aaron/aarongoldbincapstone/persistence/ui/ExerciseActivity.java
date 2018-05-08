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
import android.widget.Toast;

import com.goldbin.aaron.aarongoldbincapstone.AppInfo;
import com.goldbin.aaron.aarongoldbincapstone.R;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.FirebaseHelper;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements AppInfo {

    // instantiate widgets
    Button mAddExercise;
    Button mCancelExercise;
    Button mDeleteExercise;
    EditText mName;
    EditText mSets;
    EditText mRep;
    EditText mWeight;
    TextView mLblName;
    TextView mLblSets;
    TextView mLblReps;
    TextView mLblWeights;
//    ArrayList<Integer> mExerciseReps = new ArrayList<>();
//    ArrayList<Integer> mExerciseWeights = new ArrayList<>();


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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        mName = (EditText) (findViewById(R.id.inputExerciseName));
        mSets = (EditText) (findViewById(R.id.inputExerciseSets));
        mRep = (EditText) (findViewById(R.id.inputExerciseReps));
        mWeight = (EditText) (findViewById(R.id.inputExerciseWeight));
        mLblName = (TextView) (findViewById(R.id.lblExerciseName));
        mLblSets = (TextView) (findViewById(R.id.lblExerciseSets));
        mLblReps = (TextView) (findViewById(R.id.lblExerciseReps));
        mLblWeights = (TextView) (findViewById(R.id.lblExerciseWeights));
        mCancelExercise = (Button) (findViewById(R.id.btnCancelExercise));
        mAddExercise = (Button) (findViewById(R.id.btnAddExercise));
        mDeleteExercise = (Button) (findViewById(R.id.btnDeleteExercise));


        // check for contact being passed to activity
        Intent intent = getIntent();
        if (intent.hasExtra("EDIT_EXERCISE")) {
            mExercise = intent.getParcelableExtra("EDIT_EXERCISE");
//            mName.setText(mExercise.getMExerciseName());
//            mSets.setText(mExercise.getMSets());
//            mRep.setText(mExercise.getRep().toString());
//            mWeight.setText(mExercise.getWeights().toString());
//            mWeightBool.setChecked(mExercise.isWeightsSame());
            mAddExercise.setText(R.string.update);
        }

        // cancel button pressed
        mCancelExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // add button pressed
        mAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verify that mFirst && mLast HAVE BEEN ENTERED BEFORE BEING PASSED
                if (mName.getText().toString().trim().equalsIgnoreCase("")) {
                    mName.setError("Exercise name is required");
                } else if (mSets.getText().toString().trim().equalsIgnoreCase("")) {
                    mSets.setError("# of sets is required");
                } else if (mExercise != null) {
//                if (mExercise != null) {
                    mExercise.setExerciseName(mName.getText().toString());
                    mExercise.setSets(Integer.parseInt(mSets.getText().toString()));
                    mExercise.setReps(Integer.parseInt(mRep.getText().toString()));
                    mExercise.setWeight(Integer.parseInt(mRep.getText().toString()));

                    exerciseUpdated();
                    ExerciseActivity.super.onBackPressed();
                } else {
                    mExercise = new Exercise(
                            mName.getText().toString()
                            , Integer.parseInt(mSets.getText().toString())
                            , Integer.parseInt(mRep.getText().toString())
                            , Integer.parseInt(mWeight.getText().toString())
                    );
                    DatabaseReference fb = FirebaseDatabase
                            .getInstance()
                            .getReference(AppInfo.FIREBASE_CHILD);
                    fb.push().setValue(mExercise);
                    Toast.makeText(getApplicationContext(), "Exercise added", Toast.LENGTH_SHORT).show();
                    exerciseEntered();
                    ExerciseActivity.super.onBackPressed();
                }
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

    // back to home screen if back or cancel buttons pressed
    @Override
    public void onBackPressed () {
        super.onBackPressed();
    }
}