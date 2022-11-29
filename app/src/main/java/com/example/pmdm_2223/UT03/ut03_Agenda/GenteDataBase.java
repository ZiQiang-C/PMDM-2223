package com.example.pmdm_2223.UT03.ut03_Agenda;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Gente.class}, version = 1)
public abstract class GenteDataBase extends RoomDatabase {
    public abstract GenteDAO genteDAO();
}
