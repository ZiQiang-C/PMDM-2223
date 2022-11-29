package com.example.pmdm_2223.UT03.ut03_EjemploDato;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


import java.util.UUID;
@Entity(tableName = "persona")
public class Persona {
    @PrimaryKey
    @NotNull
    public String uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "telef")
    public String telef;

    public Persona (){
        uid = UUID.randomUUID().toString();
    }
}
