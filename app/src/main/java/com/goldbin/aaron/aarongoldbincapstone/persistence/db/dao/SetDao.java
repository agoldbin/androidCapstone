package com.goldbin.aaron.aarongoldbincapstone.persistence.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Set;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface SetDao {
    @Insert
    void insertSet (Set set);

    @Insert
    void insertSets (List<Set> setList);

    @Query("SELECT * FROM sets WHERE id = :id")
    Set fetchOneSetById(int id);

    @Query("SELECT * FROM sets")
    ArrayList<Set> getAllSets();

    @Update
    void updateSet (Set set);

    @Delete
    void deleteSet (Set set);
}
