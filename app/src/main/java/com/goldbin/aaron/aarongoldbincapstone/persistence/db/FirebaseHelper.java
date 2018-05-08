//package com.goldbin.aaron.aarongoldbincapstone.persistence.db;
//
//import android.util.Log;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import static com.goldbin.aaron.aarongoldbincapstone.AppInfo.TAG;
//
//public abstract class FirebaseHelper {
//    private DatabaseReference mDatabase;
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