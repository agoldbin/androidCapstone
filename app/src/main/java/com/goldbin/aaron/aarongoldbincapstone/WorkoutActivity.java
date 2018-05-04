package com.goldbin.aaron.aarongoldbincapstone;

import android.arch.lifecycle.BuildConfig;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.goldbin.aaron.aarongoldbincapstone.AppInfo.EXERCISE_LIST;

public class WorkoutActivity extends AppCompatActivity implements AppInfo {
    // Initialize widgets
    FloatingActionButton mFabWorkout;
    TextView mEmptyMessage;
    ListView mExerciseList;
    ArrayAdapter mExerciseArrayAdapter;
    ArrayList<Exercise> mExercises;

    // variable to access exercise info
    Exercise mExercise;


    // Save/restore instance on screen rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (android.arch.lifecycle.BuildConfig.DEBUG) {
            Log.i(TAG, "onSaveInstanceState");
        }
        savedInstanceState.putParcelableArrayList(EXERCISE_LIST, mExercises);
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
        this.mExercises = mExercises;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
//        mExerciseList = (ListView) findViewById(android.R.id.list);

        if (savedInstanceState == null) {
            // if no saved instance exists
            mExercises = new ArrayList<Exercise>();
        } else {
            // if a saved instance exists
            mExercises = savedInstanceState.getParcelableArrayList(EXERCISE_LIST);
        }

        // TODO wire up widgets
        // TODO listView of workouts. What info should be stored? Date, workout name/type(?)
        mFabWorkout = (FloatingActionButton) (findViewById(R.id.fabWorkout));
        mExerciseList = (ListView) (findViewById(android.R.id.list));
        mExerciseList.setEmptyView(mEmptyMessage);

        /*
         * Create a list adapter to adapt it to individual rows in listView
         */
        mExerciseArrayAdapter = new ExerciseArrayAdapter(this, R.layout.exercise_detail, mExercises);

        // wire up listView widget
        mExerciseList.setAdapter(mExerciseArrayAdapter);

        // enable ability to click/edit workout
        // workouts are editable
        mExerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // grab position?
                mExercise = mExercises.get(i);
                Intent intent = new Intent(WorkoutActivity.this, ExerciseActivity.class);
                intent.putExtra("EDIT_EXERCISE", mExercise);
                startActivityForResult(intent, 0);
            }
        });


        // Floating action button to add workout(how?)
        mFabWorkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutActivity.this, ExerciseActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
