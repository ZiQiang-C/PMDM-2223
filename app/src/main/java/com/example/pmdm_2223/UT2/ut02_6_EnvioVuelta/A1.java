package com.example.pmdm_2223.UT2.ut02_6_EnvioVuelta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2223.R;
import com.example.pmdm_2223.UT2.ut02_4.Receptora;

public class A1 extends AppCompatActivity {
    public static  String CLAVE_A1 = "PRIMERO";
    Button salir,enviar2;
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        salir=findViewById(R.id.ut02_6_A1_btsalir);
        enviar2=findViewById(R.id.ut02_6_A1_bt2);
        nombre=findViewById(R.id.ut02_6_A1_nombre);
        Intent i= getIntent();

        nombre.setText(i.getStringExtra(A2.CLAVE_A2));
        enviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzar();
            }
        });

    }
    private void lanzar(){
        Intent intento =new Intent(this, Receptora.class);
        intento.putExtra(CLAVE_A1,nombre.getText().toString());
        startActivity(intento);
    }
}