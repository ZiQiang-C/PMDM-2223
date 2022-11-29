package com.example.pmdm_2223.UT03.ut03_Agenda;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity(tableName = "gente")
public class Gente {

    @PrimaryKey
    @NotNull
    public String uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "telef")
    public String telef;

    public Gente (){
        uid = UUID.randomUUID().toString();
    }
    public String getNombre() {
        return nombre;
    }


    public String getTelef() {
        return telef;
    }
    public Gente(String nombre,String telef) {
        this.nombre = nombre;
        this.telef=telef;
    }
}
