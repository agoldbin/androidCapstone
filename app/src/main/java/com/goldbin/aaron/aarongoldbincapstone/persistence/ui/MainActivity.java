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
import android.widget.ListView;
import android.widget.TextView;

import com.goldbin.aaron.aarongoldbincapstone.AppInfo;
import com.goldbin.aaron.aarongoldbincapstone.R;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AppInfo {
    // Reference to database
    DatabaseReference fbRef;

    // Initialize variables and widgets
    FloatingActionButton mFabMain;
    TextView mEmptyWorkout;
    ListView mWorkoutslv;
    ArrayAdapter mWorkoutArrayAdapter;
    ArrayList<Workout> mWorkoutsArray;

    // variable to access workout info
    Workout mWorkout;

    // Save fragment on config change
    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";


    // Save/restore instance on screen rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (android.arch.lifecycle.BuildConfig.DEBUG) {
            Log.i(TAG, "onSaveInstanceState");
        }
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
        this.mWorkoutsArray = mWorkoutsArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to firebase
        fbRef = FirebaseDatabase.getInstance().getReference();
        mWorkoutslv = (ListView) findViewById(android.R.id.list);

        // TODO wire up widgets
        mFabMain = (FloatingActionButton) (findViewById(R.id.fabMain));

        mWorkoutslv = (ListView) (findViewById(R.id.lvWorkoutList));
        mWorkoutArrayAdapter = new ArrayAdapter(this, R.layout.workout_detail, mWorkoutsArray);
//        mWorkoutslv.setAdapter(mWorkoutArrayAdapter);

        mEmptyWorkout = (TextView) findViewById(android.R.id.empty);
        mWorkoutslv.setEmptyView(mEmptyWorkout);

        // add event listener for firebase
        fbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mWorkoutsArray.add(dataSnapshot.getValue(Workout.class));
                mWorkoutArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//          if workout array contains, -> replace
//                mWorkoutsArray.(dataSnapshot.getValue(Workout.class));
                mWorkoutArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                mWorkoutsArray.remove(dataSnapshot.getValue(Workout.class));
                mWorkoutArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//            if (savedInstanceState == null) {
//                // if no saved instance exists
//                mWorkoutsArray = new ArrayList<Workout>();
//            } else {
//                // if a saved instance exists
////                mWorkoutsArray = savedInstanceState.getParcelableArrayList(WORKOUT_LIST);
//            }

        // enable ability to click/edit workout
        // workouts are editable
        mWorkoutslv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mWorkout = mWorkoutsArray.get(i);
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
//                    intent.putExtra("EDIT_WORKOUT", mWorkout);
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

