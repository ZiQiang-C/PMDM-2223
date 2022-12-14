package com.example.pmdm_2223.ut01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2223.R;

public class UT01_002 extends AppCompatActivity {

    Contador global;
    TextView tGlobal;
    Button bGlobal;

    TextView tLocal1;
    Button bReset1;
    Button bAdd1;
    TextView tLocal2;
    Button bReset2;
    Button bAdd2;
    TextView tLocal3;
    Button bReset3;
    Button bAdd3;
    TextView tLocal4;
    Button bReset4;
    Button bAdd4;
    public void resta(Contador c){
        global.resta(c);
        tGlobal.setText(global.getCounter());
    }

    public void add() {
        global.add();
        tGlobal.setText(global.getCounter());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ut01002);

        // Paquete global
        global = new Contador();
        tGlobal = findViewById(R.id.tGlobal);
        bGlobal = findViewById(R.id.bGlobal);

        tLocal1 = findViewById(R.id.tLocal1);
        bReset1 = findViewById(R.id.bReset1);
        bAdd1 = findViewById(R.id.bAdd1);
        Manejador manejador1 = new Manejador(tLocal1, bAdd1, bReset1, this);
        bReset1.setOnClickListener(manejador1);
        bAdd1.setOnClickListener(manejador1);


        tLocal2 = findViewById(R.id.tLocal2);
        bReset2 = findViewById(R.id.bReset2);
        bAdd2 = findViewById(R.id.bAdd2);
        Manejador manejador2 = new Manejador(tLocal2, bAdd2, bReset2, this);
        bReset2.setOnClickListener(manejador2);
        bAdd2.setOnClickListener(manejador2);

        tLocal3 = findViewById(R.id.tLocal3);
        bReset3 = findViewById(R.id.bReset3);
        bAdd3 = findViewById(R.id.bAdd3);
        Manejador manejador3 = new Manejador(tLocal3, bAdd3, bReset3, this);
        bReset3.setOnClickListener(manejador3);
        bAdd3.setOnClickListener(manejador3);

        tLocal4 = findViewById(R.id.tLocal4);
        bReset4 = findViewById(R.id.bReset4);
        bAdd4 = findViewById(R.id.bAdd4);
        Manejador manejador4 = new Manejador(tLocal4, bAdd4, bReset4, this);
        bReset4.setOnClickListener(manejador4);
        bAdd4.setOnClickListener(manejador4);

        bGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.reset();
                tGlobal.setText(global.getCounter());
                manejador1.reset();
                manejador2.reset();
                manejador3.reset();
                manejador4.reset();
            }
        });
    }
}
