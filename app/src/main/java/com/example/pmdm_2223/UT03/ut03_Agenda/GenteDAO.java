package com.example.pmdm_2223.UT03.ut03_Agenda;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pmdm_2223.UT03.ut03_EjemploDato.Persona;

import java.util.List;
@Dao
public interface GenteDAO {
    @Query("SELECT * FROM gente")
    List<Gente> getAll();

    @Query("SELECT * FROM gente WHERE uid IN (:genteIds)")
    List<Gente> loadAllByIds (int [] genteIds);

    @Query("SELECT * FROM gente WHERE nombre LIKE :nombre LIMIT 1")
    Gente findByName(String nombre);


    @Insert
    void insertAll(Gente... users);

    @Delete
    void delete(Gente user);
    @Update
    void update(Gente... user);
}
