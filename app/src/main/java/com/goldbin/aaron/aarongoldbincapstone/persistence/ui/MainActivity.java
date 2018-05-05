package com.goldbin.aaron.aarongoldbincapstone.persistence.ui;

import android.app.FragmentManager;
//import android.app.;
import android.arch.lifecycle.BuildConfig;
import android.arch.persistence.room.Room;
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

import com.goldbin.aaron.aarongoldbincapstone.AppInfo;
import com.goldbin.aaron.aarongoldbincapstone.R;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.AGoldbinDB;
import com.goldbin.aaron.aarongoldbincapstone.persistence.model.Workout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AppInfo {
    // Initalize database
    private static final String DATABASE_NAME = "workout_db";
    private AGoldbinDB database = Room.databaseBuilder(getApplicationContext(),
    AGoldbinDB.class, DATABASE_NAME).build();

    // Save fragment on config change
    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";

    private RetainedFragment mRetainedFragment;


    // Initialize widgets
    FloatingActionButton mFabMain;
    TextView mEmptyMessage;
    ListView mWorkoutList;
    ArrayAdapter mWorkoutArrayAdapter;
    ArrayList<Workout> mWorkouts;

    // variable to access workout info
    Workout mWorkout;

    // Save/restore instance on screen rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (android.arch.lifecycle.BuildConfig.DEBUG) {
            Log.i(TAG, "onSaveInstanceState");
        }
        savedInstanceState.putAll(WORKOUT_LIST, mWorkouts);
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
        this.mWorkouts = mWorkouts;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWorkoutList = (ListView) findViewById(android.R.id.list);

        // find the retained fragment on activity restarts
        FragmentManager fm = getFragmentManager();
        mRetainedFragment = (RetainedFragment) fm.findFragmentByTag(TAG_RETAINED_FRAGMENT);

        // create the fragment and data the first time
        if (mRetainedFragment == null) {
            // add the fragment
            mRetainedFragment = new RetainedFragment();
            fm.beginTransaction().add(mRetainedFragment, TAG_RETAINED_FRAGMENT).commit();
            // load data from a data source or perform any calculation
//            mRetainedFragment.setData();


            if (savedInstanceState == null) {
            // if no saved instance exists
            mWorkouts = new ArrayList<Workout>();
        } else {
            // if a saved instance exists
            mWorkouts = savedInstanceState.getParcelableArrayList(WORKOUT_LIST);
        }

        // TODO wire up widgets
        // TODO listView of workouts. What info should be stored? Date, workout name/type(?)
        mFabMain = (FloatingActionButton) (findViewById(R.id.fabMain));
        mWorkoutList = (ListView) (findViewById(R.id.lvWorkoutList));

        /*
         * Create a list adapter to adapt it to individual rows in listView
         */
        mWorkoutArrayAdapter = new WorkoutArrayAdapter(this, R.layout.workout_detail, mWorkouts);

        // wire up listView widget
        mWorkoutList.setAdapter(mWorkoutArrayAdapter);

        // enable ability to click/edit workout
        // workouts are editable
        mWorkoutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // grab position?
                mWorkout = mWorkouts.get(i);
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                intent.putExtra("EDIT_WORKOUT", mWorkout);
                startActivityForResult(intent, 0);
            }
        });

        // Floating action button to add workout(how?)
        mFabMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
