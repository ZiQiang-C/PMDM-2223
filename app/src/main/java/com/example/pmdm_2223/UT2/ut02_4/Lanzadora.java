package com.example.pmdm_2223.UT2.ut02_4;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2223.R;

public class Lanzadora extends AppCompatActivity {
    public static  String CLAVE_INFO  = "PRIMERO";
    Button lanzador;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzadora);

        lanzador=findViewById(R.id.ut02_4lanzador);
        nombre=findViewById(R.id.ut02_4nombre);



        lanzador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzar();
            }
        });

    }
    private void lanzar(){
        Intent intento =new Intent(this,Receptora.class);
        intento.putExtra(CLAVE_INFO,nombre.getText().toString());
        startActivity(intento);
    }
}