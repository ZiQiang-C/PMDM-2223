package com.example.pmdm_2223.UT03.ut03_Agenda;

import android.widget.ImageView;

public class GenteM {
    private String nombre;
    private String telef;
    private ImageView img;
    public String getNombre() {
        return nombre;
    }


    public String getTelef() {
        return telef;
    }



    public GenteM(){}
    public GenteM(String nombre, String telef) {
        this.nombre = nombre;
        this.telef=telef;
    }
}
