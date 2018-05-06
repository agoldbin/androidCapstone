package com.goldbin.aaron.aarongoldbincapstone.persistence.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.ExerciseDao;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.SetDao;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.WorkoutDao;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Set;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;

@Database(entities = {Set.class, Exercise.class, Workout.class}, version = 1)
public abstract class AGoldbinDB extends RoomDatabase {

    public abstract SetDao setDao();
    public abstract ExerciseDao exerciseDao();
    public abstract WorkoutDao workoutDao();

    private static AGoldbinDB INSTANCE;


    static AGoldbinDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AGoldbinDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AGoldbinDB.class, "workout_db")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}

//
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.content.Context;
//
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.SetDao;
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Set;
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Workout;
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.ExerciseDao;
//import com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao.WorkoutDao;
//
//@Database(entities = {Workout.class, Exercise.class, Set.class}, version = 1)
//public abstract class AGoldbinDB extends RoomDatabase {
//
//    private static AGoldbinDB sInstance;
//
//    public abstract SetDao SetDao();
//
//    public abstract WorkoutDao WorkoutDao();
//
//    public abstract ExerciseDao ExerciseDao();
//
//}
//    private static AGoldbinDB INSTANCE;
//
//    public static AGoldbinDB getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (AGoldbinDB.class) {
//                if (INSTANCE == null) {
//                    // Create database here
//                }
//            }
//        }
//        return INSTANCE;
//    }
//    public static final String DATABASE_NAME = "workout-db";
//
////    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();
//
//    public static AGoldbinDB getInstance(final Context context) {
//        return sInstance;
//    }
//    AGoldbinDB db = Room.databaseBuilder(getApplicationContext(),
//            AGoldbinDB.class, "database-name").build();
//
//}