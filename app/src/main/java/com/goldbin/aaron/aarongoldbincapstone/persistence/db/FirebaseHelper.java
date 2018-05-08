package com.goldbin.aaron.aarongoldbincapstone.persistence.db;

import android.util.Log;

import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import static com.goldbin.aaron.aarongoldbincapstone.AppInfo.TAG;

public class FirebaseHelper {


    private DatabaseReference db;
    private Boolean saved = null;
    private ArrayList<Workout> workouts = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    // write to firebase
    public Boolean save(Workout workout) {
        if (workout == null) {
            saved = false;
        } else try {
            db.child("Workout").push().setValue(workout);
            saved = true;
        } catch (DatabaseException e) {
            e.printStackTrace();
            saved = false;
        }
        return saved;
    }

    // read from firebase

    public ArrayList<Workout> getWorkouts() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                mWorkoutsArray.add(dataSnapshot.getValue(Workout.class));
//                mWorkoutArrayAdapter.notifyDataSetChanged();
                getData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//          if workout array contains, -> replace
//                mWorkoutsArray.(dataSnapshot.getValue(Workout.class));
//                mWorkoutArrayAdapter.notifyDataSetChanged();
                getData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                mWorkoutsArray.remove(dataSnapshot.getValue(Workout.class));
//                mWorkoutArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return workouts;
    }


    public void getData(DataSnapshot dataSnapshot) {
        workouts.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Workout workout = ds.getValue(Workout.class);
//            String workoutName = ds.getValue(Workout.class).getWorkoutName();
//            Date workoutDate = ds.getValue(Workout.class).getWorkoutDate();
//            ArrayList<Exercise> exercises = ds.getValue(Workout.class).getExercises();

//            Workout workout = new Workout(workoutDate, workoutName, exercises);
            workouts.add(workout);
        }
    }

//
//    mDatabase = FirebaseDatabase.getInstance().getReference();
//
//    public DatabaseReference connectToFirebase() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        return myRef;
//    }
//
//    public void writeToFirebase() {
//        // Write a message to the database
//        DatabaseReference myRef = connectToFirebase();
//        myRef.setValue("Hello, World!");
//    }
//
//    DatabaseReference myRef = connectToFirebase();
//    // Read from the database
//    myRef.addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            // This method is called once with the initial value and again
//            // whenever data at this location is updated.
//            String value = dataSnapshot.getValue(String.class);
//            Log.d(TAG, "Value is: " + value);
//        }
//
//        @Override
//        public void onCancelled(DatabaseError error) {
//            // Failed to read value
//            Log.w(TAG, "Failed to read value.", error.toException());
//        }
//    });
//}
}