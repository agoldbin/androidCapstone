package com.goldbin.aaron.aarongoldbincapstone.persistence.ui;

import android.arch.lifecycle.BuildConfig;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.goldbin.aaron.aarongoldbincapstone.AppInfo;
import com.goldbin.aaron.aarongoldbincapstone.R;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity implements AppInfo {
    // Initialize widgets
    FloatingActionButton mFabWorkout;
    EditText mWorkoutName;
    TextView mEmptyExercise;
    ListView mExerciselv;
    ArrayAdapter mExerciseArrayAdapter;
    ArrayList<Exercise> mExerciseArray;
    Button mSaveWorkout;
    Button mDeleteWorkout;

    // variable to access exercise info
    Exercise mExercise;
    Workout mWorkout;


    // Save/restore instance on screen rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (android.arch.lifecycle.BuildConfig.DEBUG) {
            Log.i(TAG, "onSaveInstanceState");
        }
//        savedInstanceState.putParcelableArrayList(EXERCISE_LIST, mExerciseArray);
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onRestoreInstanceState(android.os.Bundle)
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onRestoreInstanceState");
        }
        this.mExerciseArray = mExerciseArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
//        mExerciselv = (ListView) findViewById(android.R.id.list);

//        if (savedInstanceState == null) {
//            // if no saved instance exists
//            mExerciseArray = new ArrayList<Exercise>();
//        } else {
//            // if a saved instance exists
////            mExerciseArray = savedInstanceState.getParcelableArrayList(EXERCISE_LIST);
//        }

        // TODO wire up widgets
        // TODO listView of workouts. What info should be stored? Date, workout name/type(?)
        mFabWorkout = (FloatingActionButton) (findViewById(R.id.fabWorkout));
        mSaveWorkout = (Button) (findViewById(R.id.btnAddWorkout));
        mDeleteWorkout = (Button) (findViewById(R.id.btnDeleteWorkout));
        mWorkoutName = (EditText) (findViewById(R.id.inputWorkoutName));

        mExerciselv = (ListView) (findViewById(android.R.id.list));
        mExerciseArrayAdapter = new ArrayAdapter(this, R.layout.workout_detail, mExerciseArray);
//        mExerciselv.setAdapter(mExerciseArrayAdapter);

        mEmptyExercise = (TextView) findViewById(android.R.id.empty);
        mExerciselv.setEmptyView(mEmptyExercise);

        // enable ability to click/edit workout
        // workouts are editable
        mExerciselv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // grab position?
                mExercise = mExerciseArray.get(i);
                Intent intent = new Intent(WorkoutActivity.this, ExerciseActivity.class);
//                intent.putExtra("EDIT_EXERCISE", mExercise);
                startActivityForResult(intent, 0);
            }
        });


        // Floating action button to add exercise
        mFabWorkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mWorkout = new Workout(mWorkoutName.getText().toString());
                Intent intent = new Intent(WorkoutActivity.this, ExerciseActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        mSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verify that workout name Has BEEN ENTERED BEFORE BEING PASSED
                if (mWorkoutName.getText().toString().trim().equalsIgnoreCase("")) {
                    // No workout name added
                    mWorkoutName.setError("Workout name is required");
                } else if (mExerciseArray.size() == 0) {
                    // No exercises added
                    Toast.makeText(
                            getApplicationContext()
                            , "Please enter at least one exercise"
                            , Toast.LENGTH_SHORT).show();
                } else if (mExerciseArray != null) {
                    mWorkout.setWorkoutName(mWorkoutName.getText().toString());
                    mWorkout.setExercises(mExerciseArray);

                    workoutUpdated();
                    WorkoutActivity.super.onBackPressed();
//                } else {
//                    mWorkout = new Workout(
//                            mWorkoutName.getText().toString()
//                            , mExerciseArray
//                    );
//
//                    workoutEntered();
//                    WorkoutActivity.super.onBackPressed();
                }
            }

        });

        mDeleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delete workout", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

    }

    // put workout info into extra to be passed to main activity
    public void workoutEntered() {
        Intent workoutData = new Intent(WorkoutActivity.this, MainActivity.class);
        setResult(0, workoutData);
    }

    // put workout info into extra to be passed to main activity
    public void workoutUpdated() {
        Intent contactData = new Intent(WorkoutActivity.this, MainActivity.class);
        setResult(0, contactData);
    }


    // back to main activity if back button pressed
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
