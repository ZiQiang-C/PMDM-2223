package com.example.pmdm_2223.UT03.ut03_Bebida;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity(tableName = "bebida")
public class BebidaTable {
    @PrimaryKey
    @NotNull
    public String uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "empresa")
    public String empresa;

    public BebidaTable (){
        uid = UUID.randomUUID().toString();
    }
    public String getNombre() {
        return nombre;
    }


    public String getEmpresa() {
        return empresa;
    }
    public BebidaTable(String nombre,String empresa) {
        this.nombre = nombre;
        this.empresa=empresa;
    }
}
