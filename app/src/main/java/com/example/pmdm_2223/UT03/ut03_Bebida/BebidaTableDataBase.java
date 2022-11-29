package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pmdm_2223.UT03.ut03_Agenda.Gente;
import com.example.pmdm_2223.UT03.ut03_Agenda.GenteDAO;

@Database(entities = {BebidaTable.class}, version = 1)
public abstract class BebidaTableDataBase extends RoomDatabase {
    public abstract BebidaTableDAO bebidaTableDAO();
}
