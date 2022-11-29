package com.example.pmdm_2223.UT2.ut02_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class Pracatica21
        extends AppCompatActivity
        implements View.OnClickListener{
    int contador;
    Button suma,resta,reset;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pracatica21);
        contador=0;
        suma = findViewById(R.id.suma);
        suma.setOnClickListener(this);
        resta = findViewById(R.id.resta);
        resta.setOnClickListener(this);
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
        texto = findViewById(R.id.texto);
    }
    @Override
    public void onClick(View view) {
        nintendo(view.getId());
    }
    public void nintendo(int opcion){

        switch (opcion){
            case R.id.suma:
                contador++;
                break;
            case R.id.resta:
                if(0>=contador)
                    contador=0;
                else
                    contador--;
                break;
            case R.id.reset:
                contador=0;
                break;
        }
        texto.setText(String.valueOf(contador));
    }

}