package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface BebidaTableDAO {
    @Query("SELECT * FROM bebida")
    List<BebidaTable> getAll();

    @Query("SELECT * FROM bebida WHERE uid IN (:genteIds)")
    List<BebidaTable> loadAllByIds (int [] genteIds);

    @Query("SELECT * FROM bebida WHERE nombre LIKE :nombre LIMIT 1")
    BebidaTable findByName(String nombre);


    @Insert
    void insertAll(BebidaTable... users);

    @Delete
    void delete(BebidaTable user);
    @Update
    void update(BebidaTable... user);
}
