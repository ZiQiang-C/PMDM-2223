package com.example.pmdm_2223.UT03.ut03_EjemploDato;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonaDAO {
    @Query("SELECT * FROM persona")
    List<Persona> getAll();

    @Query("SELECT * FROM persona WHERE uid IN (:personaIds)")
    List<Persona> loadAllByIds (int [] personaIds);

    @Query("SELECT * FROM persona WHERE nombre LIKE :nombre LIMIT 1")
     Persona findByName(String nombre);


    @Insert
    void insertAll(Persona... users);

    @Delete
    void delete(Persona user);
}
