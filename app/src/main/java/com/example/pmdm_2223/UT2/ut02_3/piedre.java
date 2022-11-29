package com.example.pmdm_2223.UT2.ut02_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm_2223.R;

import java.util.Random;

public class piedre extends AppCompatActivity {
    ImageButton Piedra,Tijera,Papel;
    Button Reset;
    TextView VisualM,Gana,Mi,Miguel;
    enum Jugada {
        PIEDRA,
        PAPEL,
        TIJERA
    }
    int contarMiguel=0,contarMi=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedre);

        Piedra=findViewById(R.id.Piedra);
        Tijera=findViewById(R.id.Tijera);
        Papel=findViewById(R.id.Papel);
        Reset=findViewById(R.id.piedreReset);

        VisualM=findViewById(R.id.pasaMiguel);
        Mi=findViewById(R.id.MiPuntu);
        Miguel=findViewById(R.id.MiguelPuntu);
        Gana=findViewById(R.id.gana);

       reset();
       Reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               reset();
           }
       });

       View.OnClickListener manejador =new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Jugada maquina =maquinaJuega();
               Jugada jugador;
            if(v.getId()==Piedra.getId()){
                jugador =Jugada.PIEDRA;
            }else if (v.getId() == Papel.getId()){
                jugador = Jugada.PAPEL;
            } else {
                jugador = Jugada.TIJERA;
            }
               VisualM.setText(""+maquina);
               if(maquina == jugador) {
                   Gana.setText("Empate");
                   Gana.setBackgroundColor(0xFFFEF5E7);
               } else if(
                       ((maquina == Jugada.PAPEL) && (jugador == Jugada.TIJERA)) ||
                               ((maquina == Jugada.PIEDRA) && (jugador == Jugada.PAPEL)) ||
                               ((maquina == Jugada.TIJERA) && (jugador == Jugada.PIEDRA))
               ) {
                   contarMi++;
                   Mi.setText(""+contarMi);
                   Gana.setText("¡Ganas!");
                   Gana.setBackgroundColor(0xFFD5F5E3);
               } else {
                   contarMiguel++;
                   Miguel.setText(""+contarMiguel);
                   Gana.setText("Pierdes :(");
                   Gana.setBackgroundColor(0xFFFADBD8);
               }
           }

       };

        Tijera.setOnClickListener(manejador);
        Papel.setOnClickListener(manejador);
        Piedra.setOnClickListener(manejador);

    }
    public  void  reset(){
        contarMiguel=0;
        contarMi=0;
        VisualM.setText("");
        Gana.setText("");
        Mi.setText(""+contarMi);
        Miguel.setText(""+contarMiguel);
    }

    private Jugada maquinaJuega(){
        return Jugada.values()[new Random().nextInt(Jugada.values().length)];
    }
}