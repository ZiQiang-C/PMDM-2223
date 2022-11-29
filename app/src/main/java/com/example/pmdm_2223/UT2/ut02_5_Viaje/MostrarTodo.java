package com.example.pmdm_2223.UT2.ut02_5_Viaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.UT03.ut03_EjemploDato.Dato;

public class MostrarTodo extends AppCompatActivity {
    TextView mostraTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_todo);
        mostraTodo=findViewById(R.id.mostrarTodo);

        Intent i =getIntent();

        mostraTodo.setText(i.getStringExtra(Viajes.CLAVE_VIAJE));

    }
}