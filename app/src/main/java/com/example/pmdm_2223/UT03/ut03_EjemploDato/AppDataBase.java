package com.example.pmdm_2223.UT03.ut03_EjemploDato;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PersonaDAO personaDAO();
}
